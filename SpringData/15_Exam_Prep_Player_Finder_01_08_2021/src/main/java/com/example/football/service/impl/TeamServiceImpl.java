package com.example.football.service.impl;

import com.example.football.models.dto.ImportTeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final Validator validator;
    private TownRepository townRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().
                getValidator();
    }


    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {

        Path path = Path.of("src", "main", "resources" , "files",
                "json", "teams.json");

        return Files.readString(path);
    }

    @Override
    public String importTeams() throws IOException {
        String json = readTeamsFileContent();

        List<String> output = new ArrayList<>();

        ImportTeamDTO[] importTeamDTOS = this.gson.fromJson(json, ImportTeamDTO[].class);

        for (ImportTeamDTO importTeamDTO : importTeamDTOS) {
            Set<ConstraintViolation<ImportTeamDTO>> errors = this.validator.validate(importTeamDTO);

            if(errors.isEmpty()){
                Optional<Team> optionalTeam = this.teamRepository.findByName(importTeamDTO.getName());

                if(optionalTeam.isEmpty()){
                    Team team = this.mapper.map(importTeamDTO, Team.class);

                    Optional<Town> town = this.townRepository.findByName(importTeamDTO.getTownName());

                    team.setTown(town.get());

                    this.teamRepository.save(team);

                    output.add(String.format("Successfully imported Team %s - %d",
                            team.getName(),team.getFanBase()));
                }

                else{
                    output.add("Invalid Team");
                }
            }

            else{
                output.add("Invalid Team");
            }
        }

        return output.stream().collect(Collectors.joining("\n"));
    }
}
