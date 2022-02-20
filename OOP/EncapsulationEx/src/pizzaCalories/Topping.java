package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
       setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType){
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":break;
            default:
                String message=
                        String.format("Cannot place %s on top of your pizza.",toppingType);
                throw new IllegalArgumentException(message);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight<1||weight>50){
            String message=String.format("%s weight should be in the range [1..50].",this.toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double result=this.weight*2;
        switch (this.toppingType){
            case "Meat":result*=1.2;break;
            case "Veggies":result*=0.8;break;
            case "Cheese":result*=1.1;break;
            case "Sauce":result*=0.9;break;

    }
    return  result;
    }
}
