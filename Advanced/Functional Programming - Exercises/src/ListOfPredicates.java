import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOfPredicates {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n = Integer.parseInt(scann.nextLine());

        List<Integer> numbers = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());


        BiFunction<Integer, List<Integer>, Boolean> checkDivideToElementInCollection =
                (e, list) -> {
                    for (Integer elementInList : list) {
                        if (e % elementInList != 0) return false;
                    }
                    return true;
                };

        for (int i = 1; i <= n; i++) {
            if (checkDivideToElementInCollection.apply(i, numbers)) {
                System.out.print(i + " ");
            }
        }


    }
}
