package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
       setFlourType(flourType);
       setBakingTechnique(bakingTechnique);
       setWeight(weight);
    }

    private void setFlourType(String flourType) {
if(!flourType.equals("White")&&!flourType.equals("Wholegrain")){
    getMessageInvalidDough();
}
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy") &&
                !bakingTechnique.equals("Chewy") &&
                !bakingTechnique.equals("Homemade")){
           getMessageInvalidDough();
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight<1||weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public double calculateCalories(){
        double result=this.weight*2;
        switch (this.flourType){
            case "White": result*=1.5;break;
            case "Wholegrain": result*=1.0;break;
        }
        switch (this.bakingTechnique){
            case "Crispy": result*=0.9;break;
            case "Chewy": result*=1.1;break;
            case "Homemade": result*=1.0;break;
        }
        return result;
    }


    private void getMessageInvalidDough(){
       throw new IllegalArgumentException("Invalid type of dough.");
    }
}
