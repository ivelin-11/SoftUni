import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
You can receive the following TPRF commands: "Add filter", "Remove filter" or "Print".
 The possible TPRF filter types are: "Starts with", "Ends with", "Length" and "Contains".
  All TPRF filter parameters will be a string (or an integer for the length filter).
 */


//Contains is not given punctual description
public class ThePartyReservationFilter {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<String> people = Arrays.stream(scann.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> invitations = people;
        String[] command = scann.nextLine().split(";");

        while (!command[0].equals("Print")) {

            if (command[0].equals("Add filter")) {
                invitations = removeInvitations(invitations, command[1], command[2]);
            } else if (command[0].equals("Remove filter")) {
                invitations.addAll( addInvitations(people, command[1], command[2]));
            }

            command = scann.nextLine().split(";");
        }


        System.out.println(invitations.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(" ")));
    }

    private static List<String> removeInvitations(List<String> peopleToRemove, String command, String commandParameter) {

        if (command.equals("Starts with")) {
            return peopleToRemove.stream().filter(e -> !e.startsWith(commandParameter)).collect(Collectors.toList());
        } else if (command.equals("Ends with")) {
            return peopleToRemove.stream().filter(e -> !e.endsWith(commandParameter)).collect(Collectors.toList());
        } else {
            return peopleToRemove.stream().filter(e -> e.length() != Integer.parseInt(commandParameter)).collect(Collectors.toList());
        }
    }

    private static List<String> addInvitations(List<String> names, String command, String commandParameter) {

        if (command.equals("Starts with")) {
            return names.stream().filter(e -> e.startsWith(commandParameter)).collect(Collectors.toList());
        } else if (command.equals("Ends with")) {
            return names.stream().filter(e -> e.endsWith(commandParameter)).collect(Collectors.toList());
        } else {
            return names.stream().filter(e -> e.length() == Integer.parseInt(commandParameter)).collect(Collectors.toList());
        }
    }
}

