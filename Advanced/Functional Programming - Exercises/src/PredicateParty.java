import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {


    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<String> names = Arrays.stream(scann.nextLine().split("\\s+")).collect(Collectors.toList());

        String[] command = scann.nextLine().split("\\s+");

        while (!command[0].equals("Party!")) {

            if (command[0].equals("Double")) {
                names = doubleNames(names, command[1], command[2]);
            } else if (command[0].equals("Remove")) {
                names = removeNames(names, command[1], command[2]);
            }

            command = scann.nextLine().split("\\s+");
        }

        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        System.out.println(names.stream().sorted().collect(Collectors.joining(", "))+ " are going to the party!");
    }

    private static List<String> doubleNames(List<String> names, String command, String commandParameter) {

        List<String> namesToDouble;
        if (command.equals("StartsWith")) {
            namesToDouble = names.stream().filter(e -> e.startsWith(commandParameter)).collect(Collectors.toList());
        } else if (command.equals("EndsWith")) {
            namesToDouble = names.stream().filter(e -> e.endsWith(commandParameter)).collect(Collectors.toList());
        } else {
            namesToDouble = names.stream().filter(e -> e.length() == Integer.parseInt(commandParameter)).collect(Collectors.toList());
        }

        names.addAll(namesToDouble);
        return names;
    }

    private static List<String> removeNames(List<String> names, String command, String commandParameter) {
        if (command.equals("StartsWith")) {
            return names.stream().filter(e -> !e.startsWith(commandParameter)).collect(Collectors.toList());
        } else if (command.equals("EndsWith")) {
            return names.stream().filter(e -> !e.endsWith(commandParameter)).collect(Collectors.toList());
        }
        return names.stream().filter(e -> e.length() != Integer.parseInt(commandParameter)).collect(Collectors.toList());
    }
}
