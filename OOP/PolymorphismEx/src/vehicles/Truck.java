package vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    public Truck(Double fuelQuantity, Double fuelConsumption){
        super(fuelQuantity,fuelConsumption);
    }


    @Override
    public String drive(Double distance) {
        Double fuelNeeded = this.getFuelConsumption() * distance;

        DecimalFormat df1 = new DecimalFormat("###.##");

        if (this.getFuelQuantity() >= fuelNeeded) {
            this.setFuelQuantity(fuelNeeded);
            return String.format("Truck travelled %s km",
                   df1.format(distance));
        }
        return "Truck needs refueling";

    }

    @Override
    public void refuel(Double fuelAdd) {
        super.refuel((0.95*fuelAdd));
    }
}
