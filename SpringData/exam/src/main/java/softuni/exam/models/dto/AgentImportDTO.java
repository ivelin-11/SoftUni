package softuni.exam.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AgentImportDTO {

    @NotNull
    @Size(min =2)
    private String firstName;

    @NotNull
    @Size(min =2)
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    //represents town name
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTown() {
        return town;
    }
}
