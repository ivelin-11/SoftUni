package exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.model.dtos.LaptopImportDTO;
import exam.model.entities.Laptop;
import exam.model.entities.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class LaptopServiceImpl implements LaptopService {

    Path path = Path.of("src", "main", "resources", "files", "json", "laptops.json");

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private Gson gson;
    private ModelMapper modelMapper;
    private Validator validator;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importLaptops() throws IOException {

        String json = readLaptopsFileContent();

        LaptopImportDTO[] laptopImportDTOS = this.gson.fromJson(json, LaptopImportDTO[].class);

        return Arrays.stream(laptopImportDTOS).map(this::importLaptop).collect(Collectors.joining("\n"));

    }

    private String importLaptop(LaptopImportDTO laptopImportDTO) {

        Set<ConstraintViolation<LaptopImportDTO>> errors = this.validator.validate(laptopImportDTO);

        if (errors.size() > 0) {
            return "Invalid Laptop";
        }

        Optional<Laptop> optionalLaptop = this.laptopRepository.findByMacAddress(laptopImportDTO.getMacAddress());

        if (optionalLaptop.isPresent()) {
            return "Invalid Laptop";
        }

        Laptop laptop = this.modelMapper.map(laptopImportDTO, Laptop.class);

        Optional<Shop> optionalShop = this.shopRepository.findByName(laptopImportDTO.getShop().getName());

        laptop.setShop(optionalShop.get());

        this.laptopRepository.save(laptop);

        return String.format("Successfully imported Laptop %s – %.2f – %d -%d", laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam()
                , laptop.getStorage());
    }

    @Override
    public String exportBestLaptops() {
        List<Laptop> laptops = this.laptopRepository.findAllOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();

        return laptops.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
