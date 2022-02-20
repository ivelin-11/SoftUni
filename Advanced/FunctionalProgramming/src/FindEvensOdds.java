import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split(" ");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        String command = scanner.nextLine();

        printNumbersIn(start, end,
                command.equals("odd") ?
                        n -> n % 2 != 0
                        : n -> n % 2 == 0);
    }

    public static void printNumbersIn(int startInclusive, int endInclusive, Predicate<Integer> predicate) {
        IntStream.rangeClosed(startInclusive, endInclusive).boxed().filter(predicate)
                .forEach(d -> System.out.printf("%d ", d));
    }
}
