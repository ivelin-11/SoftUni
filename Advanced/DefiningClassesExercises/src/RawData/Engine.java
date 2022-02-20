package RawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    Engine(int engineSpeed,int enginePower){
        this.engineSpeed=engineSpeed;
        this.enginePower=enginePower;
    }
    public boolean checkEnginePower(){
        if(this.enginePower>250){
            return true;
        }
        return false;
    }

}
