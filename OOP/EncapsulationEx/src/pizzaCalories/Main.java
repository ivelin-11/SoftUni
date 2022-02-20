package pizzaCalories;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
//pizza input
        String[] input=scann.nextLine().split("\\s+");
        String pizzaName=input[1];
        int numberOfToppings=Integer.parseInt(input[2]);
        Pizza pizza=new Pizza(pizzaName,numberOfToppings);


        // dough input
        input=scann.nextLine().split("\\s+");
        String flourType=input[1];
        String bakingTechnique=input[2];
        double weightDough=Double.parseDouble(input[3]);
        Dough dough=new Dough(flourType,bakingTechnique,weightDough);
        pizza.setDough(dough);

        //toppings input
        input=scann.nextLine().split("\\s+");
        while(!input[0].equals("END")){

String toppingType=input[1];
double weightTopping=Double.parseDouble(input[2]);

Topping topping=new Topping(toppingType,weightTopping);
pizza.addTopping(topping);
            input=scann.nextLine().split("\\s+");
        }

        DecimalFormat decimalFormat=new DecimalFormat("#.00");
        System.out.printf("%s - %s%n",pizza.getName(),decimalFormat.format(pizza.getOverallCalories()));
    }
}
