package single_table_and_relations;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="plate_numbers")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    @OneToOne(mappedBy = "plateNumber",targetEntity = Car.class)
    private Car car;

    public PlateNumber() {
    }

    public PlateNumber(String number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
