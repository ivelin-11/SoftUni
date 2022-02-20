package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

     private String livingRegion;


    public Mammal(String animalName, String animalType, Double animalWeight,String livingRegion) {
        super(animalName,animalType,animalWeight);
        this.livingRegion=livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }


    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    protected void eat(Food food) {
super.eat(food);
    }

    @Override
    protected void makeSound() {

    }

    @Override
    public String toString() {

        DecimalFormat df1=new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",getAnimalType(),getAnimalName(),df1.format(getAnimalWeight()),
                getLivingRegion(),getFoodEaten());
    }
}
