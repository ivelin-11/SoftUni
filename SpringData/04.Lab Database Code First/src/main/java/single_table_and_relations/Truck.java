package single_table_and_relations;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("truck")
public class Truck extends Vehicle {

    private static final String TRUCK_TYPE = "Truck";

    @Column(name = "load_capacity")
    private Double loadCapacity;


    public Truck() {
    }

    public Truck(String model, BigDecimal price, String fuelType, Double loadCapacity) {
        super( TRUCK_TYPE,model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }


    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }




}
