package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerImportDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;

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
public class PassengerServiceImpl implements PassengerService {
    Path path = Path.of("src", "main", "resources", "files", "json", "passengers.json");


    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final Validator validator;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, TownRepository townRepository) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPassengers() throws IOException {
        String json = readPassengersFileContent();

        List<String> output = new ArrayList<>();

        PassengerImportDTO[] passengerImportDTOS = this.gson.fromJson(json, PassengerImportDTO[].class);

        for (PassengerImportDTO passengerImportDTO : passengerImportDTOS) {

            Set<ConstraintViolation<PassengerImportDTO>> errors = this.validator.validate(passengerImportDTO);

            if (errors.size() == 0 && this.passengerRepository.findByEmail(passengerImportDTO.getEmail()).isEmpty()) {
                Passenger passenger = this.mapper.map(passengerImportDTO, Passenger.class);

                Optional<Town> optTown = this.townRepository.findByName(passengerImportDTO.getTown());

                passenger.setTown(optTown.get());

                this.passengerRepository.save(passenger);

                output.add(String.format("Successfully imported Passenger %s - %s",passenger.getLastName(),passenger.getEmail()));
            }

            else{
                output.add("Invalid passenger");
            }
        }

        return String.join("\n",output);
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

       return  this.passengerRepository.findAllOrderByTicketsSizeDescEmailAsc().stream()
                .map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
