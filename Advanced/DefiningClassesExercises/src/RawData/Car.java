package RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tires> tiresList;

    Car(String model,Engine engine,Cargo cargo,List<Tires> tiresList){
        this.model=model;
        this.engine=engine;
        this.cargo=cargo;
        this.tiresList=tiresList;
    }

    public String getModel() {
        return model;
    }

    public boolean checkTire() {
        for (Tires a:tiresList) {
            if(a.isFragile()){
                return true;
            }
        }
        return false;
    }

    public boolean checkEnginePower(){
        return engine.checkEnginePower();
    }

}
