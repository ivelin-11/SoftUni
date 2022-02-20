import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scann.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toList());


        System.out.println(numbers.stream().filter(e -> e % 2 == 0).map(String::valueOf).
                collect(Collectors.joining(", ")));


        System.out.println(numbers.stream().filter(e -> e % 2 == 0).
                sorted().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
