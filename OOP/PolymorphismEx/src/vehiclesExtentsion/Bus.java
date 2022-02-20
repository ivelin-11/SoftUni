package vehiclesExtentsion;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(Double distance) {
        Double fuelNeeded = this.getFuelConsumption() * distance;

        DecimalFormat df1 = new DecimalFormat("###.##");

        if (this.getFuelQuantity() >= fuelNeeded) {
            this.setFuelQuantity(fuelNeeded);
            return String.format("Bus travelled %s km", df1.format(distance));
        }
        return "Bus needs refueling";

    }
}
