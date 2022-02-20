package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight,  livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void eat(Food food) {
        super.eat(food);
    }
    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


    public String toString() {

        DecimalFormat df1=new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",getAnimalType(),getAnimalName(),getBreed(),df1.format(getAnimalWeight()),
                getLivingRegion(),getFoodEaten());
    }
}


