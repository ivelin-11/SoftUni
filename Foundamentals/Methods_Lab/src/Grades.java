import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        double number=Double.parseDouble(scann.nextLine());
        printGrade(number);
    }
    public static void printGrade(double a){
        if(a>=2&&a<=2.99) {
            System.out.println("Fail");
        }
        else if(a>=3&&a<=3.49) {
            System.out.println("Poor");
        }
        else if(a>=3.50&&a<=4.49) {
            System.out.println("Good");
        }
        else if(a>=4.50&&a<=5.49) {
            System.out.println("Very good");
        }
        else if(a>=5.50&&a<=6) {
            System.out.println("Excellent");
        }
    }
}
