import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int number=Integer.parseInt(scann.nextLine());
        checkPositiveNegative(number);
    }
    public static void checkPositiveNegative(int a){
        if(a>0) {
            System.out.println("The number " +a+" is positive.");
        }
        else if(a<0) {
            System.out.println("The number " +a+" is negative.");
        }
        else if(a==0) {
            System.out.println("The number " +a+" is zero.");
        }

    }

}
