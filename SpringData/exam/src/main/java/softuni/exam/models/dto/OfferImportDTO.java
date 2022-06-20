package softuni.exam.models.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDTO {

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;



    @XmlElement(name = "agent")
    private AgentNameDTO agentNameDTO;

    @XmlElement(name = "apartment")
    private ApartmentIdDTO apartmentIdDTO;

    @NotNull
    @XmlElement
    private String publishedOn;

    public BigDecimal getPrice() {
        return price;
    }

    public AgentNameDTO getAgentNameDTO() {
        return agentNameDTO;
    }

    public ApartmentIdDTO getApartmentIdDTO() {
        return apartmentIdDTO;
    }

    public String getPublishedOn() {
        return publishedOn;
    }
}
