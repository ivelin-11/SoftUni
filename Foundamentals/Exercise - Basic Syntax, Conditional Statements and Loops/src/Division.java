import java.util.Scanner;
public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = 0;
        if (a % 10 == 0) {
            b = 10;
        }
        else if (a % 2 == 0 && a % 10 == 0) {
            b = 10;
        }
        else if (a % 7 == 0) {
            b = 7;
        }
        else if (a % 2 == 0 && a % 3 == 0) {
            b = 6;
        }
        else if (a % 3 == 0) {
            b = 3;
        }
        else if (a % 2 == 0) {
            b = 2;
        }

        else {
            b = 0;
            System.out.println("Not divisible");
        }
        if (b > 0) {
            System.out.printf("The number is divisible by %d", b);
        }
    }
}
