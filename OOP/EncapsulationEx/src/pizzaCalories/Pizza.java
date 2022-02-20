package pizzaCalories;

import java.util.*;

public class Pizza {
    private String name;
    private Dough dough;
    private List <Topping> toppings;

public Pizza(String name,int numberOfToppings){
    setName(name);
    setToppings(numberOfToppings);
}

    private void setName(String name) {
        if(name==null||name.isEmpty()||name.trim().isEmpty()||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

   private void setToppings(int numberOfToppings) {
        if(numberOfToppings<0||numberOfToppings>10){
throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings =new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping){
    this.toppings.add(topping);
    }

    public  double getOverallCalories(){
    double result=this.dough.calculateCalories();

    result+=this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    return  result;
    }
}