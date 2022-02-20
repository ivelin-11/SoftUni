package testAbstractClass;

public class Penguin extends  Bird implements Swimmers{
    public Penguin(String name,double weight){
        super(name,weight);
    }

    @Override
    public String swim() {
        return "swimming...";
    }

    @Override
    public String toString() {
        return super.toString()+" is only "+ swim();
    }
}
