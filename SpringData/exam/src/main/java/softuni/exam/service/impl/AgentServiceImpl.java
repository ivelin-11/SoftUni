package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

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
public class AgentServiceImpl implements AgentService {

    Path path = Path.of("src", "main", "resources", "files", "json", "agents.json");

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator valdator;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
        this.valdator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importAgents() throws IOException {

        String json = readAgentsFromFile();

        AgentImportDTO[] agentImportDTOS = this.gson.fromJson(json, AgentImportDTO[].class);

        return Arrays.stream(agentImportDTOS).map(this::importAgent).collect(Collectors.joining("\n"));

    }

    private String importAgent(AgentImportDTO agentImportDTO) {

        Set<ConstraintViolation<AgentImportDTO>> errors = this.valdator.validate(agentImportDTO);

        if (errors.size() > 0) {
            return "Invalid agent";
        }

        //check both firstName and email(doesn't include in the task condition) if already has such user with them to avoid duplicates
        //because they are unique

        Optional<Agent> optionalAgent = this.agentRepository.findByFirstName(agentImportDTO.getFirstName());

        if (optionalAgent.isPresent()) {
            return "Invalid agent";
        }

        Optional<Agent> optionalAgent2 = this.agentRepository.findByEmail(agentImportDTO.getEmail());

        if (optionalAgent2.isPresent()) {
            return "Invalid agent";
        }


        //check if townName is valid because it doesn't written in task to be valid(doesn't given in the constraints)
        Optional<Town> optionalTown = this.townRepository.findByTownName(agentImportDTO.getTown());

        if (optionalTown.isEmpty()) {
            return "Invalid agent";
        }

        Agent agent = this.modelMapper.map(agentImportDTO, Agent.class);

        agent.setTown(optionalTown.get());

        this.agentRepository.save(agent);

        return String.format("Successfully imported agent - %s %s", agent.getFirstName(), agent.getLastName());
    }
}
