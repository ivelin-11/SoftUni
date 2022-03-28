package com.example.football.service.impl;

import com.example.football.models.dto.ImportStatDTO;
import com.example.football.models.dto.ImportStatRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private final Path path = Path.of("src", "main", "resources", "files", "xml", "stats.xml");
    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private Unmarshaller unmarshaller;
    private Validator validator;

    @Autowired
    public StatServiceImpl(StatRepository statRepository) throws JAXBException {
        this.statRepository = statRepository;
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        JAXBContext context = JAXBContext.newInstance(ImportStatRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {


        return Files.readString(path);
    }

    @Override
    public String importStats() throws FileNotFoundException, JAXBException {

        ImportStatRootDTO importStatRootDTO = (ImportStatRootDTO)
                this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

       return importStatRootDTO.getStats().stream().map(this::importStat).
               collect(Collectors.joining("\n"));

    }

    private String importStat(ImportStatDTO importStatDTO) {

        Set<ConstraintViolation<ImportStatDTO>> errors =
                this.validator.validate(importStatDTO);

        if (!errors.isEmpty()) {
            return "Invalid Stat";
        }

        Optional<Stat> optionalStat = this.statRepository.findByShootingAndPassingAndEndurance(importStatDTO.getShooting(),
                importStatDTO.getPassing(), importStatDTO.getEndurance());

        if(optionalStat.isPresent()){
            return "Invalid Stat";
        }

        Stat stat = this.modelMapper.map(importStatDTO, Stat.class);

        this.statRepository.save(stat);

        return  String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                stat.getShooting(),stat.getPassing(),stat.getEndurance());
    }
}
