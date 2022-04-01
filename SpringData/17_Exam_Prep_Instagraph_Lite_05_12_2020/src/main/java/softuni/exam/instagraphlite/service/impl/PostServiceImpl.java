package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostImportDTO;
import softuni.exam.instagraphlite.models.dto.PostImportRootDTO;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    Path path = Path.of("src", "main", "resources", "files", "posts.xml");

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private Unmarshaller unmarshaller;

    @Autowired
    public PostServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, PostRepository postRepository) throws JAXBException {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        JAXBContext context = JAXBContext.newInstance(PostImportRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {


        PostImportRootDTO postImportRootDTO = (PostImportRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return
                postImportRootDTO.getPosts().stream().map(this::importPost).collect(Collectors.joining("\n"));

    }

    private String importPost(PostImportDTO postImportDTO) {

        Set<ConstraintViolation<PostImportDTO>> errors = this.validator.validate(postImportDTO);

        if (errors.size() > 0) {
            return "Invalid Post";
        }

        Optional<Picture> optionalPicture = this.pictureRepository.findByPath(postImportDTO.getPicture().getPath());

        if (optionalPicture.isEmpty()) {
            return "Invalid Post";
        }

        Optional<User> optionalUser = this.userRepository.findByUsername(postImportDTO.getUser().getUsername());

        if (optionalUser.isEmpty()) {
            return "Invalid Post";
        }

        Post post = this.modelMapper.map(postImportDTO, Post.class);

        post.setPicture(optionalPicture.get());
        post.setUser(optionalUser.get());

        this.postRepository.save(post);


        return String.format("Successfully imported Post, made by %s", post.getUser().getUsername());
    }
}
