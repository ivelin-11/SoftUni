package com.example.football.service.impl;

import com.example.football.models.dto.ImportPlayerDTO;
import com.example.football.models.dto.ImportPlayerRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    Path path = Path.of("src", "main", "resources", "files", "xml", "players.xml");

    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final Unmarshaller unmarshaller;
    private final Validator validator;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository) throws JAXBException {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        JAXBContext context = JAXBContext.newInstance(ImportPlayerRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(path);

    }

    @Override
    public String importPlayers() throws FileNotFoundException, JAXBException {

        ImportPlayerRootDTO importPlayerRootDTO = (ImportPlayerRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return importPlayerRootDTO.getPlayers().stream().map(this::importPlayer).collect(Collectors.joining("\n"));


    }

    private String importPlayer(ImportPlayerDTO importPlayerDTO) {

        Set<ConstraintViolation<ImportPlayerDTO>> errors = this.validator.validate(importPlayerDTO);

        if (!errors.isEmpty()) {
            return "Invalid Player";
        }


        Optional<Player> optionalPlayer = this.playerRepository.findByEmail(importPlayerDTO.getEmail());

        if (optionalPlayer.isPresent()) {
            return "Invalid Player";
        }

        Player player = this.modelMapper.map(importPlayerDTO, Player.class);

        Optional<Town> optionalTown = this.townRepository.findByName(importPlayerDTO.getTownNameDTO().getName());
        Optional<Team> optionalTeam = this.teamRepository.findByName(importPlayerDTO.getTeamNameDTO().getName());
        Optional<Stat> optionalStat = this.statRepository.findById(importPlayerDTO.getStatIdDTO().getId());

        player.setTown(optionalTown.get());
        player.setTeam(optionalTeam.get());
        player.setStat(optionalStat.get());

        this.playerRepository.save(player);

        return String.format("Successfully imported Player %s %s - %s",
                player.getFirstName(), player.getLastName(), player.getPosition().toString());
    }

    @Override
    public String exportBestPlayers() {
        LocalDate after= LocalDate.of(1995,1,1);
        LocalDate before= LocalDate.of(2003,1,1);

        List<Player> players = this.playerRepository.findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);
        return players.stream().map(Player::toString).collect(Collectors.joining("\n"));
    }
}
