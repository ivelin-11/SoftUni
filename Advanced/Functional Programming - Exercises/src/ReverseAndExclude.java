import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt).
                collect(Collectors.toList());

        int n=Integer.parseInt(scann.nextLine());

        Predicate<Integer> divisibleByNumber = e-> e%n!=0;
        Consumer<Integer> printer = e-> System.out.print(e+" ");
        List<Integer> filteredNumbers = numbers.stream().filter(divisibleByNumber).collect(Collectors.toList());

   Collections.reverse(filteredNumbers);
       filteredNumbers.forEach(printer);


    }
}
