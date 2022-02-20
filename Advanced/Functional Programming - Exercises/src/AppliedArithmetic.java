import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int[] numbers = Arrays.stream(scann.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(num -> num += 1).toArray();
        Function<int[], int[]> mult = arr -> Arrays.stream(arr).map(num -> num *= 2).toArray();
        Function<int[], int[]> sub = arr -> Arrays.stream(arr).map(num -> num -= 1).toArray();
        Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String command = scann.nextLine();


        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = mult.apply(numbers);
                    break;
                case "subtract":
                    numbers =  sub.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;

                default:
                    break;
            }

            command = scann.nextLine();
        }
    }
}
