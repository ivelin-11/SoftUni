import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int ch = 1; ch <= n; ch++) {
            int sum = 0; int a = 0;

            a = ch;
            while (a > 0) {
                int b= a%10;
                sum+=b;
                a= a / 10;
            }
            if((sum == 5) || (sum == 7) || (sum == 11)){
                System.out.printf("%d -> True%n", ch);
                sum = 0;

            }
            else {

                System.out.printf("%d -> False%n", ch);

                sum = 0;

            }
        }

    }
}
