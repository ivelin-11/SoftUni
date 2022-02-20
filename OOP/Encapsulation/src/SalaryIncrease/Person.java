package SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age,double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary=salary;
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

    public void setSalary(double salary) {
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
}
