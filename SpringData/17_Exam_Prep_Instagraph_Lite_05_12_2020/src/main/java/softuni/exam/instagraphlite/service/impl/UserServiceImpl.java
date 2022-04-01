package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserImportDTO;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    Path path = Path.of("src", "main", "resources", "files", "users.json");

    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public UserServiceImpl(PictureRepository pictureRepository, UserRepository userRepository) {
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importUsers() throws IOException {

        String json = readFromFileContent();

        UserImportDTO[] userImportDTOS = this.gson.fromJson(json, UserImportDTO[].class);

        return
                Arrays.stream(userImportDTOS).map(this::importUser).collect(Collectors.joining("\n"));

    }

    private String importUser(UserImportDTO userImportDTO) {

        Set<ConstraintViolation<UserImportDTO>> errors = this.validator.validate(userImportDTO);

        if(errors.size() >0){
            return "Invalid User";
        }


        Optional<User> optionalUser = this.userRepository.findByUsername(userImportDTO.getUsername());

        if(optionalUser.isPresent()){
            return "Invalid User";
        }

        Optional<Picture> optionalPicture = this.pictureRepository.findByPath(userImportDTO.getPicture());

        if(optionalPicture.isEmpty()){
            return "Invalid User";
        }

        User user = this.modelMapper.map(userImportDTO, User.class);

        user.setPicture(optionalPicture.get());

        this.userRepository.save(user);

        return String.format("Successfully imported User: %s",user.getUsername());
    }

    @Override
    public String exportUsersWithTheirPosts() {

        List<User> users = this.userRepository.findAllWithPosts();
        return users.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
