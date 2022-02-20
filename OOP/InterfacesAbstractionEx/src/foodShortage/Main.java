package foodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        Map<String, Buyer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scann.nextLine());

        while (n-- > 0) {

            String[] input = scann.nextLine().split("\\s+");

            if (input.length == 4) {
                people.putIfAbsent(input[0], new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]));
            } else if (input.length == 3) {
                people.putIfAbsent(input[0], new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
            }

        }


        int boughtFood=0;
        String command = scann.nextLine();
        while (!command.equals("End")) {

            if (people.containsKey(command)) {
people.get(command).buyFood();
              people.get(command).getFood();
            }

            command= scann.nextLine();
        }

        System.out.println(boughtFood);
    }
}
