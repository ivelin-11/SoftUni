package testAbstractClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Bird> birds=new ArrayList<>();

        Bird penguin=new Penguin("Penguin", 20.123123);
        Bird raven=new Raven("Raven",15.123123);
        Bird duck=new Duck("Duck",10);

        birds.add(penguin);
        birds.add(raven);
        birds.add(duck);


        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }
}
