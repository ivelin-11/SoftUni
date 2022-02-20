package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmout;
    private double consumption;
    private double ditanceTraveled;

    public Car(String model,double fuelAmount,double consumption){
        this.model=model;
        this.fuelAmout=fuelAmount;
        this.consumption=consumption;
        this.ditanceTraveled=0;
    }

    public boolean drive(double kilometers){
double fuelRequired=kilometers*consumption;
if(fuelRequired>this.fuelAmout){
    return false;}
    else{
        this.fuelAmout-=fuelRequired;
        this.ditanceTraveled+=kilometers;
        return true;
    }
}

    public String getModel() {
        return model;
    }

    public double getFuelAmout() {
        return fuelAmout;
    }

    public double getDitanceTraveled() {
        return ditanceTraveled;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %.2f %.0f",this.model,this.fuelAmout,this.ditanceTraveled);
    }
}


