package single_table_and_relations;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity()
@DiscriminatorValue("bike")
public class Bike extends Vehicle {

    private static final String BIKE_TYPE = "Bike";
    public Bike() {
    }

    public Bike(String model, BigDecimal price, String fuelType) {
        super(BIKE_TYPE,model, price, fuelType);
    }
}
