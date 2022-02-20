package sayHelloExtended;

public class BasePerson implements Person{
    private String name;

    protected BasePerson(String name){
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return null;
    }
}
