package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDTO;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    Path path = Path.of("src", "main", "resources", "files", "json", "towns.json");

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final Validator validator;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper= new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
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

        TownImportDTO[] townImportDTOS = this.gson.fromJson(json, TownImportDTO[].class);

        List<String> output =new ArrayList<>();

        for (TownImportDTO townImportDTO : townImportDTOS) {
            Set<ConstraintViolation<TownImportDTO>> errors = this.validator.validate(townImportDTO);

            if(errors.size()==0 && townRepository.findByName(townImportDTO.getName()).isEmpty()){

                Town town = this.mapper.map(townImportDTO, Town.class);
                this.townRepository.save(town);
                output.add(String.format("Successfully imported Town %s - %d",town.getName(),town.getPopulation()));
            }
            else{
                output.add("Invalid Town");
            }
        }

        return String.join("\n", output);
    }
}
