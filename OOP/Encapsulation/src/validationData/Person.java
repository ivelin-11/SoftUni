package validationData;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setAge(int age) {
        if(age<=0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setFirstName(String firstName) {
        if(!chekNameLength(firstName)){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(!chekNameLength(lastName)){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        if(salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if(this.age<30){
            this.salary+=(bonus/2*this.salary)/100;
        }
        else{
            this.salary+=(bonus*this.salary)/100;
        }
}
    @Override
    public String toString() {
        DecimalFormat df1=new DecimalFormat("##.0####");
        return getFirstName()+" "+getLastName()+" gets "+
                String.format("%s",df1.format(getSalary()))+" leva";
    }
    public boolean chekNameLength(String name){
        return name.length() >= 3;
    }

}
