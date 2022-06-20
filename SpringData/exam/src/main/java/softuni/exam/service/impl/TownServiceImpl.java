package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    Path path = Path.of("src", "main", "resources", "files", "json", "towns.json");

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator valdator;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
        this.valdator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importTowns() throws IOException {

        String json = readTownsFileContent();

        TownImportDTO[] townDTOS = this.gson.fromJson(json, TownImportDTO[].class);

        return Arrays.stream(townDTOS).map(this::importTown).collect(Collectors.joining("\n"));

    }

    private String importTown(TownImportDTO townDTO) {

        Set<ConstraintViolation<TownImportDTO>> errors = this.valdator.validate(townDTO);

        if (errors.size() > 0) {
            return "Invalid town";
        }

        //name is unique check for repeated names
        Optional<Town> optionalTown = this.townRepository.findByTownName(townDTO.getTownName());

        if (optionalTown.isPresent()) {
            return "Invalid town";
        }
        Town town = this.modelMapper.map(townDTO, Town.class);

        this.townRepository.save(town);

        return String.format("Successfully imported town %s - %d", town.getTownName(), town.getPopulation());

    }
}
