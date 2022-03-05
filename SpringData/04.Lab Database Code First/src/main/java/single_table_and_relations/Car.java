package single_table_and_relations;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle {

    private Integer seats;

    private static final String CAR_TYPE="Car";

    @OneToOne
    @JoinColumn(name = "number_id",referencedColumnName = "id")
    private PlateNumber plateNumber;


    public Car() {
    }

    public Car(String model, BigDecimal price, String fuelType, Integer seats, PlateNumber plateNumber) {
        super(CAR_TYPE,model, price, fuelType);
        this.seats = seats;
        this.plateNumber = plateNumber;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }
}
