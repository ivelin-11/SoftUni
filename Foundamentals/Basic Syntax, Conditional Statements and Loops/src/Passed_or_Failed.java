import java.util.Scanner;
public class Passed_or_Failed {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        double grade=Double.parseDouble(scann.nextLine());
        if(grade>2.99){
            System.out.println("Passed!");
        }
        else{
            System.out.println("Failed!");
        }
    }
}
