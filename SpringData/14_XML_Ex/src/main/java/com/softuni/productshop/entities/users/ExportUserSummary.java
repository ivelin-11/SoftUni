package com.softuni.productshop.entities.users;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)

public class ExportUserSummary {

    @XmlAttribute
    private int count;

    @XmlElement(name = "user")
    List<UserInfoDTO> users;

    public void setCount(int count) {
        this.count = count;
    }

    public void setUsers(List<UserInfoDTO> users) {
        this.users = users;
    }
}
