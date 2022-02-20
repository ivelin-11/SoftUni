package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        List<Identifiable> entries = new ArrayList<>();

        String[] tokens = scann.nextLine().split("\\s+");

        while (!tokens[0].equals("End")) {

            if (tokens.length == 2) {
                entries.add(new Robot(tokens[0], tokens[1]));
            } else if (tokens.length == 3) {
                entries.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }
            tokens = scann.nextLine().split("\\s+");
        }

        String searchedLastDigits= scann.nextLine();

        entries.stream().map(Identifiable::getId)
                .filter(e->e.endsWith(searchedLastDigits)).collect(Collectors.toList())
                .forEach(System.out::println);



    }
}
