package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }


    private void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age<0||age>15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");

        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay (){
return calculateProductPerDay();
    }
    private double calculateProductPerDay(){
        double eggsProduction=0;
        if(this.age>=0&&this.age<=5){
            eggsProduction=2;
        }
        else if(this.age>=6&&this.age<=11){
            eggsProduction=1;
        }
        else{
            eggsProduction=0.75;
        }
        return eggsProduction;
    }


    @Override
    public String toString() {
        return String.format(
                "Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name,this.age,productPerDay());
    }
}
