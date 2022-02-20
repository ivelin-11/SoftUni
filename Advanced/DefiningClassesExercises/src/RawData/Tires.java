package RawData;

public class Tires {

    private double tirePressure;
    private int tireAge;

    Tires(double tirePressure,int tireAge){
        this.tirePressure=tirePressure;
        this.tireAge=tireAge;


    }
    public boolean isFragile(){
        if(this.tirePressure<1){
            return true;
        }
        return false;
    }

}
