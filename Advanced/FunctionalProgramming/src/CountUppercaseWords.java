import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CountUppercaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperCase = str -> Character.isUpperCase(str.charAt(0));

        System.out.println(Arrays.stream(text).filter(isUpperCase).count());

        Arrays.stream(text).filter(e -> isUpperCase.test(e)).
                forEach(System.out::println);


    }
}
