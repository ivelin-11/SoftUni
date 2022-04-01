package exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.model.dtos.CustomerImportDTO;
import exam.model.entities.Customer;
import exam.model.entities.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    Path path = Path.of("src", "main", "resources", "files", "json", "customers.json");

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private Gson gson;
    private ModelMapper modelMapper;
    private Validator validator;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importCustomers() throws IOException {
        String json = readCustomersFileContent();

        CustomerImportDTO[] customerImportDTOS = this.gson.fromJson(json, CustomerImportDTO[].class);

        return  Arrays.stream(customerImportDTOS).map(this::importCustomer).collect(Collectors.joining("\n"));

    }

    private String importCustomer(CustomerImportDTO customerImportDTO) {

        Set<ConstraintViolation<CustomerImportDTO>> errors = this.validator.validate(customerImportDTO);

        if (errors.size() > 0) {
            return "Invalid Customer";
        }

        Optional<Customer> optionalCustomer = this.customerRepository.findByEmail(customerImportDTO.getEmail());

        if (optionalCustomer.isPresent()) {
            return "Invalid Customer";
        }

        Customer customer = this.modelMapper.map(customerImportDTO, Customer.class);

        Optional<Town> optionalTown = this.townRepository.findByName(customerImportDTO.getTown().getName());

        customer.setTown(optionalTown.get());

        this.customerRepository.save(customer);

        return String.format("Successfully imported Customer %s %s - %s",customer.getFirstName(),customer.getLastName(),customer.getEmail());
    }
}
