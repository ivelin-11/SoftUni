package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneImportDTO;
import softuni.exam.models.dto.PlaneImportRootDTO;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;

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
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {

    Path path = Path.of("src", "main", "resources", "files", "xml", "planes.xml");

    private final PlaneRepository planeRepository;
    private final Unmarshaller unmarshaller;
    private final ModelMapper mapper;
    private final Validator validator;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository) throws JAXBException {
        this.planeRepository = planeRepository;
        this.mapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        JAXBContext context = JAXBContext.newInstance(PlaneImportRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPlanes() throws FileNotFoundException, JAXBException {

        PlaneImportRootDTO planeImportRootDTO = (PlaneImportRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return planeImportRootDTO.getPlaneImportDTOS().stream().map(this::importPlane).collect(Collectors.joining("\n"));

    }

    private String importPlane(PlaneImportDTO planeImportDTO) {

        Set<ConstraintViolation<PlaneImportDTO>> errors = this.validator.validate(planeImportDTO);

        if (errors.size() > 0 ||
                this.planeRepository.findByRegisterNumber(planeImportDTO.getRegisterNumber()).isPresent()) {

            return "Invalid Plane";
        }

        Plane plane = this.mapper.map(planeImportDTO, Plane.class);

        this.planeRepository.save(plane);

        return String.format("Successfully imported Plane %s",plane.getRegisterNumber());
    }
}
