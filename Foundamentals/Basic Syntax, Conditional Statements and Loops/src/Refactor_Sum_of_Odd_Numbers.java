import java.util.Scanner;
public class Refactor_Sum_of_Odd_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0,a=0;
        for (int i = 1; i <= n; i++) {
            a=2 * i - 1;
            System.out.println(a);
            sum=sum+ a;
        }
        System.out.printf("Sum: %d", sum);

    }
}
