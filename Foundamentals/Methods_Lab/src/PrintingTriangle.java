import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n = Integer.parseInt(scann.nextLine());
        printTriangle(n);
    }
    public static void printTriangle(int number){
        int br = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1 + " ");
                br++;
            }

            System.out.println();


        }
        for (int i = number; i > 0; i--) {
            for (int j = 1; j <=i-1; j++) {
                System.out.print(j + " ");
                br++;
            }
            if (br >0) {
                System.out.println();
                br=0;
            }
        }
    }
}
