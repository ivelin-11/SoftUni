import java.util.Scanner;

public class Multiplication_Table2 {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int a=Integer.parseInt(scann.nextLine());
        int n=Integer.parseInt(scann.nextLine());
        int multiplication=0;
        if(n>0&&n<10) {
            for (int i = n; i <= 10; i++) {
                multiplication = a * i;
                System.out.printf("%d X %d = %d %n", a, i, multiplication);
                multiplication = 0;
            }
        }
        else{
            multiplication =a *n;
            System.out.printf("%d X %d = %d %n", a, n,multiplication);
        }
        }
    }

