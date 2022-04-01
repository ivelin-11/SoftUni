package exam.model.dtos;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportDTO {

    @XmlElement
    @NotNull
    @Size(min = 2)
    private String name;

    @XmlElement
    @NotNull
    @Positive
    private int population;

    @XmlElement(name = "travel-guide")
    @NotNull
    @Size(min = 10)
    private String travelGuide;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }
}
