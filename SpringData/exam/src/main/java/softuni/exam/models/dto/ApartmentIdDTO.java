package softuni.exam.models.dto;


import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentIdDTO {

    @XmlElement
    private long id;


    public long getId() {
        return id;
    }
}
