package softuni.exam.models.dto;

import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Town;


import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDTO {

    @Size(min =2)
    @XmlElement(name = "serial-number")
    private String serialNumber;

    @Positive
    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeoff;

     @XmlElement(name = "from-town")
    private TownNameDTO fromTown;

    @XmlElement(name = "to-town")
    private TownNameDTO toTown;

    @XmlElement(name = "passenger")
    private PassengerMailDTO email;

    @XmlElement(name = "plane")
    private PlaneNumberDTO plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public TownNameDTO getFromTown() {
        return fromTown;
    }

    public TownNameDTO getToTown() {
        return toTown;
    }

    public PassengerMailDTO getEmail() {
        return email;
    }

    public PlaneNumberDTO getPlane() {
        return plane;
    }
}
