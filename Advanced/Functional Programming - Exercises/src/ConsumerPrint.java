import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        String [] input=scann.nextLine().split("\\s+");

        Consumer<String> printer = e->System.out.println(e);

        Arrays.stream(input).forEach(printer);
    }
}
