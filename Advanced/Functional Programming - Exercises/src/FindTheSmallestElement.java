import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>,Integer> getMin= list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getMin.apply(numbers));
    }
}
