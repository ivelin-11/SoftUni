package testAbstractClass;

public class Raven extends Bird implements Flyable{

    public Raven(String name,double weight){
        super(name,weight);
    }

    @Override
    public String fly() {
        return "flying...";
    }

    @Override
    public String toString() {
        return super.toString()+" is only "+ fly();
    }
}
