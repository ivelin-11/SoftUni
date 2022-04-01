package exam.model.dtos;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportDTO {

    @XmlElement
    @Size(min =4)
    @NotNull
    private String address;

    @NotNull
    @Min(1)
    @Max(50)
    @XmlElement(name = "employee-count")
    private int employeeCount;

    @NotNull
    @Min(20000)
    @XmlElement
    private BigDecimal income;

    @XmlElement
    @Size(min =4)
    @NotNull
    private String name;

    @XmlElement(name = "shop-area")
    @NotNull
    @Min(150)
    private int shopArea;


    @XmlElement(name = "town")
    private TownNameDTO town;

    public String getAddress() {
        return address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public String getName() {
        return name;
    }

    public int getShopArea() {
        return shopArea;
    }

    public TownNameDTO getTown() {
        return town;
    }
}
