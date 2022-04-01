package softuni.exam.instagraphlite.models.dto;

import softuni.exam.instagraphlite.models.entities.Picture;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserImportDTO {

    @NotNull
    @Size(min = 2,max =18)
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    @NotNull
    private String profilePicture;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return profilePicture;
    }
}
