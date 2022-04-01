package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureImportDTO;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    Path path = Path.of("src", "main", "resources", "files", "pictures.json");


    private final PictureRepository pictureRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepo) {
        this.pictureRepo = pictureRepo;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
        this.validator= Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepo.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPictures() throws IOException {
        String json = readFromFileContent();

        PictureImportDTO[] pictureImportDTOS = this.gson.fromJson(json, PictureImportDTO[].class);


       return Arrays.stream(pictureImportDTOS).map(this::importPicture).collect(Collectors.joining("\n"));

    }

    private String importPicture(PictureImportDTO pictureImportDTO) {

        Set<ConstraintViolation<PictureImportDTO>> errors = this.validator.validate(pictureImportDTO);

        if(errors.size()>0){
            return "Invalid Picture";
        }

        Optional<Picture> optPicture = this.pictureRepo.findByPath(pictureImportDTO.getPath());

        if(optPicture.isPresent()){
            return "Invalid Picture";
        }

        Picture picture = this.modelMapper.map(pictureImportDTO, Picture.class);

        this.pictureRepo.save(picture);

        return String.format("Successfully imported Picture, with size %.2f",picture.getSize());
    }

    @Override
    public String exportPictures() {
        List<Picture> pictures = this.pictureRepo.findAllBySizeGreaterThanOrderBySizeAsc(BigDecimal.valueOf(30000));

        return pictures.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
