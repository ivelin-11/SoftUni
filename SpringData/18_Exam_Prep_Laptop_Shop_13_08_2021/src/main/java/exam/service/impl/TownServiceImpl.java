package exam.service.impl;

import exam.model.dtos.TownImportDTO;
import exam.model.dtos.TownImportRootDTO;
import exam.model.entities.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import org.modelmapper.ModelMapper;
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    Path path = Path.of("src", "main", "resources", "files", "xml", "towns.xml");


    private final TownRepository townRepository;
    private final Validator validator;
    private final Unmarshaller unmarshaller;
    private ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) throws JAXBException {
        this.townRepository = townRepository;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        JAXBContext context = JAXBContext.newInstance(TownImportRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
        this.modelMapper = new ModelMapper();
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
    public String importTowns() throws JAXBException, FileNotFoundException {

        TownImportRootDTO townImportRootDTO = (TownImportRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return townImportRootDTO.getTowns().stream().map(this::importTown).collect(Collectors.joining("\n"));

    }

    private String importTown(TownImportDTO townImportDTO) {

        Set<ConstraintViolation<TownImportDTO>> errors = this.validator.validate(townImportDTO);

        if (errors.size() > 0) {
            return "Invalid Town";
        }

        Optional<Town> optionalTown = this.townRepository.findByName(townImportDTO.getName());

        if (optionalTown.isPresent()) {
            return "Invalid Town";
        }

        Town town = this.modelMapper.map(townImportDTO, Town.class);

        this.townRepository.save(town);

        return String.format("Successfully imported Town %s",town.getName());

    }
}
