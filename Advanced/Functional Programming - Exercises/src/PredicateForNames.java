import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n = Integer.parseInt(scann.nextLine());

        String[] names = scann.nextLine().split("\\s+");

        Predicate<String> checkNameLength = e -> e.length() <= n ;

        Arrays.stream(names).filter(checkNameLength).forEach(System.out::println);
    }
}
