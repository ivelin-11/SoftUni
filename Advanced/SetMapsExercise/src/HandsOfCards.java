import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        String[] input = scann.nextLine().split(":");

        Map<String, List<String>> playersDecks = new LinkedHashMap<>();

        while (!input[0].equals("JOKER")) {

            String name = input[0];
            List<String> deck = Arrays.stream(input[1].split(",")).collect(Collectors.toList());




                playersDecks.putIfAbsent(name, new ArrayList<>());
                for (String card : deck) {

                    if (!playersDecks.get(name).contains(card)) playersDecks.get(name).add(card);

                }

            input = scann.nextLine().split(":");
        }


        for (Map.Entry<String, List<String>> entry : playersDecks.entrySet()) {
            int cardsValue = 0;
            for (String card : entry.getValue()) {
                cardsValue += getCardPower(card);
            }
            System.out.printf("%s: %d%n", entry.getKey(), cardsValue);

        }
    }

    private static int getCardPower(String card) {

        int numberPower = 0;
        if (card.length() == 4) {
            String temp = String.valueOf(card.charAt(1)) + String.valueOf
                    (card.charAt(2));
            numberPower = Integer.parseInt(temp);
        } else {
            switch (card.charAt(1)) {
                case '2':
                    numberPower += 2;
                    break;
                case '3':
                    numberPower += 3;
                    break;
                case '4':
                    numberPower += 4;
                    break;
                case '5':
                    numberPower += 5;
                    break;
                case '6':
                    numberPower += 6;
                    break;
                case '7':
                    numberPower += 7;
                    break;
                case '8':
                    numberPower += 8;
                    break;
                case '9':
                    numberPower += 9;
                    break;
                case 'J':
                    numberPower += 11;
                    break;
                case 'Q':
                    numberPower += 12;
                    break;
                case 'K':
                    numberPower += 13;
                    break;
                case 'A':
                    numberPower += 14;
                    break;
                default:
                    break;
            }
        }


        char color = card.charAt(card.length() - 1);
        int colorPower = 0;
        switch (color) {
            case 'S':
                colorPower = 4;
                break;
            case 'H':
                colorPower = 3;
                break;
            case 'D':
                colorPower = 2;
                break;
            case 'C':
                colorPower = 1;
                break;
            default:
                colorPower = 0;
                break;
        }

        return colorPower * numberPower;
    }
}
