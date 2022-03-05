package single_table_and_relations;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("plane")
public class Plane extends Vehicle {

    private static final String PLANE_TYPE = "Plane";

    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    @ManyToOne
    @JoinColumn(name ="company_id",referencedColumnName = "id")
    private Company company;

    public Plane() {
    }

    public Plane(String model, BigDecimal price, String fuelType, Integer passengerCapacity, Company company) {
        super(PLANE_TYPE, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.company = company;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
