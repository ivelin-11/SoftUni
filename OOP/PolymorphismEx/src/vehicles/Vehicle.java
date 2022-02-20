package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;


    protected Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected abstract String drive(Double distance) ;

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity =this.fuelQuantity- fuelQuantity;
    }

    protected void refuel(Double fuelAdd){
        this.fuelQuantity+=fuelAdd;
}

}
