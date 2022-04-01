package exam.model.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerImportDTO {

    @Size(min =2)
    @NotNull
    private String firstName;

    @Size(min =2)
    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String registeredOn;

    @NotNull
    private TownNameDTO town;

    public TownNameDTO getTown() {
        return town;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }
}
