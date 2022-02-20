import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);


        String[] input = scann.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int number = 0;

        Set<Integer> N = new LinkedHashSet<>();
        Set<Integer> M = new LinkedHashSet<>();

        while (n-- > 0) {
            number = Integer.parseInt(scann.nextLine());
            N.add(number);
        }
        while (m-- > 0) {
            number = Integer.parseInt(scann.nextLine());
            M.add(number);
        }

        if (n > m || n == m) {
            N.forEach(a -> {
                for (Integer b : M) {
                    if (Objects.equals(a, b)) {
                        System.out.print(a+" ");
                    }
                }
                ;
            });
        } else if (m > n) {
            M.forEach(a -> {
                for (Integer b : N) {
                    if (Objects.equals(a, b)) {
                        System.out.println(a+" ");
                    }
                }
                ;
            });
        }
    }
}
