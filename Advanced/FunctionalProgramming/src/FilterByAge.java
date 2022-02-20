import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterByAge {

    private static class People {
        private String name;
        private int age;

        People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n = Integer.parseInt(scann.nextLine());

        Supplier<People> peopleFactory = () ->
        {
            String[] input = scann.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            return new People(name, age);
        };

        List<People> people = IntStream.range(0, n).
                mapToObj(ignored -> peopleFactory.get())
                .collect(Collectors.toList());

        String criteria = scann.nextLine();
        int ageLimit = Integer.parseInt(scann.nextLine());
        String[] format = scann.nextLine().split("\\s+");

        Predicate<People> filter = getFilter(criteria, ageLimit);
        Consumer<People> printer=getPrinter(format);

        people.stream().filter(filter).forEach(printer);
    }

    public static Predicate<People> getFilter(String criteria, int ageLimit) {
        if (criteria.equals("older")) {
            return p -> p.age >= ageLimit;
        }
        return p -> p.age <= ageLimit;
    }

    public static Consumer<People> getPrinter(String[] format) {
        if (format.length == 2) {
            return p -> {
                System.out.println(p.name + " - " + p.age);
            };
        } else if (format[0].equals("name")) {
            return p -> {
                System.out.println(p.name);
            };
        }
        return p -> {
            System.out.println(p.age);
        };
    }
}
