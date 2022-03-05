package single_table_and_relations;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//set the strategy to TABLE_PER_CLASS to explain the relations in more appropriate way

@DiscriminatorColumn(name = "type")
public abstract class Vehicle {

    @Id()
    @GeneratedValue(strategy = GenerationType.TABLE)
    //or by identity because we have base table of the existed class
    private long id;


    @Column(insertable = false, updatable = false)
    private String type;

    @Column(nullable = false)
    private String model;


    private BigDecimal price;


    private String fuelType;

    public Vehicle() {
    }

    protected Vehicle(String type, String model, BigDecimal price, String fuelType) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
