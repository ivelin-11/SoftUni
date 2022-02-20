package testAbstractClass;

public class Duck extends Bird implements Flyable,Swimmers{

    public Duck(String name,double weight){
        super(name,weight);
    }

    @Override
    public String fly() {
        return "flying...";
    }
    public String swim() {
        return "swimming...";
    }

    @Override
    public String toString() {
        return super.toString()+" is "+fly()+" and "+swim();
    }
}
