package com.softuni.productshop.entities.users;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportRootDTO {

    @XmlElement(name = "user")
    List<UserImportDTO> users;

    public List<UserImportDTO> getUsers() {
        return users;
    }
}
