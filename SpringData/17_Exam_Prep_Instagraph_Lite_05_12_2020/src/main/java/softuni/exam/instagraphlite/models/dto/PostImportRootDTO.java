package softuni.exam.instagraphlite.models.dto;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportRootDTO {

    @XmlElement(name = "post")
    private List<PostImportDTO> posts;

    public List<PostImportDTO> getPosts() {
        return posts;
    }
}
