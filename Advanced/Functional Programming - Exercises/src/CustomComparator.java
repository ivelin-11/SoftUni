import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = (e, e1) -> {
            if (e % 2 == 0 && e1 % 2 != 0) {
                return -1;
            } else if (e % 2 != 0 && e1 % 2 == 0) {
                return 1;
            } else {
                return e.compareTo(e1);
            }
        };

        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));

//        numbers.stream().filter(e->e%2==0).sorted().forEach(e-> System.out.print(e+" "));
//        numbers.stream().filter(e->e%2!=0).sorted().forEach(e-> System.out.print(e+" "));


    }
}
