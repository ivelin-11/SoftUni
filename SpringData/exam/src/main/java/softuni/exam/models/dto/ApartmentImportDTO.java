package softuni.exam.models.dto;


import softuni.exam.models.entity.ApartmentType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDTO {

    @NotNull
    @XmlElement
    private String apartmentType;

    @NotNull
    @XmlElement
    @Min(40)
    private BigDecimal area;

    //represent townName
    @NotNull
    @XmlElement
    private String town;


    public String getApartmentType() {
        return apartmentType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public String getTown() {
        return town;
    }
}
