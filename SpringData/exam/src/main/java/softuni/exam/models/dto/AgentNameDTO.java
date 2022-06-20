package softuni.exam.models.dto;


import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class AgentNameDTO {

    @XmlElement
    private String name;

    public String getName() {
        return name;
    }
}
