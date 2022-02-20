import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);


        String input = scann.nextLine();

        Map<Character, Integer> histogram = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (histogram.putIfAbsent(input.charAt(i), 1) == null) {
            } else {
                histogram.put(input.charAt(i), histogram.get(input.charAt(i)) + 1);
            }
        }

        histogram.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));

    }
}
