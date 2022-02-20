package vehiclesExtentsion;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected abstract String drive(Double distance);

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    protected void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = this.fuelQuantity - fuelQuantity;
    }

    protected void refuel(Double fuelAdd) {
        if (fuelAdd <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (fuelAdd + this.fuelQuantity >= this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuelAdd;
    }

}
