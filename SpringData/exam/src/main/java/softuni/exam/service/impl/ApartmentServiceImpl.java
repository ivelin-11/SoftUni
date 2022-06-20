package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportDTO;
import softuni.exam.models.dto.ApartmentImportRootDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    Path path = Path.of("src","main","resources","files","xml","apartments.xml");

    private final TownRepository townRepository;
    private final ApartmentRepository apartmentRepository;
    private final Unmarshaller unmarshaller;
    private final ModelMapper modelMapper;
    private final Validator valdator;

    @Autowired
    public ApartmentServiceImpl(TownRepository townRepository, ApartmentRepository apartmentRepository) throws JAXBException {
        this.townRepository = townRepository;
        this.apartmentRepository = apartmentRepository;
        JAXBContext context=JAXBContext.newInstance(ApartmentImportRootDTO.class);
        this.unmarshaller= context.createUnmarshaller();
        this.modelMapper = new ModelMapper();
        this.valdator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() >0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        ApartmentImportRootDTO apartmentImportRootDTO = (ApartmentImportRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return apartmentImportRootDTO.getApartments().stream().map(this::importApartment).collect(Collectors.joining("\n"));
    }

    private String importApartment(ApartmentImportDTO apartmentImportDTO) {

        Set<ConstraintViolation<ApartmentImportDTO>> errors = this.valdator.validate(apartmentImportDTO);

        if(errors.size() >0){
            return "Invalid apartment";
        }

        //If the apartment with the same town name and area already exists in the DB return "Invalid apartment"
        //The provided town names will always be valid.

        //this query
        Optional<Town> optionalTown = this.townRepository.findByTownName(apartmentImportDTO.getTown());
        Optional<Apartment> optionalApartment = this.apartmentRepository.findByAreaAndTown(apartmentImportDTO.getArea(), optionalTown.get());

        if(optionalApartment.isPresent()){
            return "Invalid apartment";
        }

        Apartment apartment = this.modelMapper.map(apartmentImportDTO, Apartment.class);



        apartment.setTown(optionalTown.get());

        this.apartmentRepository.save(apartment);

        return  String.format("Successfully imported apartment %s - %s",apartment.getApartmentType().toString(),apartment.getArea().toString());
    }
}
