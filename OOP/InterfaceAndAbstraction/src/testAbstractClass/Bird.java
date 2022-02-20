package testAbstractClass;

import java.text.DecimalFormat;

public class Bird {
    private String name;
    private double weight;

    public Bird(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        DecimalFormat df1=new DecimalFormat("#########.######");

        return String.format("Type: %s, Weight: %s",name,df1.format(weight));
    }
}
