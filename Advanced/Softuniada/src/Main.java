import soft2017.ooo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static  abstract class Animal implements ooo {
     String name=" adasd";
    }
    static  class Dog extends Animal{
String age="1";
    }
    static  class Dolphin extends Animal{
        String age="1";
    }

    public static void main(String[] args) {

        List <Animal> animals=new ArrayList<>();
        animals.add(new Dolphin());
        System.out.println(animals.get(0).name);
    }
}
