import java.util.Scanner;
public class StudentInformation {
    public static void main (String[] args){
    Scanner scann=new Scanner(System.in);
   String name=scann.nextLine();
    int age=Integer.parseInt(scann.nextLine());
double grade=Double.parseDouble(scann.nextLine());
System.out.printf("Name: %s, Age: %d, Grade: %.2f",name,age,grade);

    }

}
