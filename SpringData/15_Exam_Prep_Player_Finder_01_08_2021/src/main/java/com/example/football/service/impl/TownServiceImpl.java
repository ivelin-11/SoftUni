package com.example.football.service.impl;

import com.example.football.models.dto.ImportTownDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TownServiceImpl implements TownService {


    private final TownRepository townRepo;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepo) {
        this.townRepo = townRepo;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.validator = Validation.buildDefaultValidatorFactory()
                .getValidator();

        this.mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.townRepo.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {

        Path path = Path.of("src", "main", "resources",
                "files", "json", "towns.json");
        return Files.readString(path);
    }

    @Override
    public String importTowns() throws IOException {

        String json = readTownsFileContent();

        ImportTownDTO[] importTownDTOS = this.gson.fromJson(json, ImportTownDTO[].class);

        List<String> output = new ArrayList<>();

        for (ImportTownDTO importTownDTO : importTownDTOS) {
            Set<ConstraintViolation<ImportTownDTO>> errors = this.validator.validate(importTownDTO);

            if (errors.isEmpty()) {

                Optional<Town> optTown = townRepo.findByName(importTownDTO.getName());

                if (optTown.isEmpty()) {
                    Town town = this.mapper.map(importTownDTO, Town.class);

                    this.townRepo.save(town);
                    output.add(String.format("Successfully imported Town %s - %d",
                            town.getName(), town.getPopulation()));
                } else {
                    output.add("Invalid Town");
                }
            } else {
                output.add("Invalid Town");
            }
        }
        return output.stream().collect(Collectors.joining("\n"));
    }
}
