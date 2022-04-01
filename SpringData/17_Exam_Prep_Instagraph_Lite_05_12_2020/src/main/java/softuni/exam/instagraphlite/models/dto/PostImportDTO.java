package softuni.exam.instagraphlite.models.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDTO {

    @XmlElement
    @NotNull
    @Size(min = 21)
    private String caption;

    @NotNull
    @XmlElement(name = "user")
    private UserNameDTO user;

    @NotNull
    @XmlElement(name = "picture")
    private PicturePathDTO picture;


    public String getCaption() {
        return caption;
    }

    public UserNameDTO getUser() {
        return user;
    }

    public PicturePathDTO getPicture() {
        return picture;
    }
}
