package com.example.football.models.dto;


import com.example.football.models.entity.PlayerPosition;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerDTO {


    @Size(min = 3)
    @XmlElement(name = "first-name")
    private String firstName;

    @Size(min = 3)
    @XmlElement(name = "last-name")
    private String lastName;

    @Email
    @XmlElement
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement
    private PlayerPosition position;

    @XmlElement(name = "town")
    private TownNameDTO townNameDTO;

    @XmlElement(name = "team")
    private TeamNameDTO teamNameDTO;

    @XmlElement(name = "stat")
    private StatIdDTO statIdDTO;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public TownNameDTO getTownNameDTO() {
        return townNameDTO;
    }

    public TeamNameDTO getTeamNameDTO() {
        return teamNameDTO;
    }

    public StatIdDTO getStatIdDTO() {
        return statIdDTO;
    }
}
