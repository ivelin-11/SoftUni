package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        String[] input = scann.nextLine().split("\\s+");
        int lineCounter = 2;//become from even number

        List<Animal> animals = new ArrayList<>();

        while (!input[0].equals("End")) {

            Animal animal = createAnimal(input);


            //second time for food
            input = scann.nextLine().split("\\s+");

            Food food=getFood(input);
            animal.makeSound();

            try{
                animal.eat(food);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            animals.add(animal);
            input=scann.nextLine().split("\\s+");//read the animal again
        }

        animals.forEach(System.out::println);
    }


    public static Animal createAnimal(String[] tokens) {
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];
        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            case "Cat":
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, tokens[4]);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }

    public static Food getFood(String[] tokens) {
        String type = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        if (type.equals("Meat")) {
            return new Meat(quantity);
        } else return new Vegetable(quantity);
    }






}
