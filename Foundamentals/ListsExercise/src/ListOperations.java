import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scann.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scann.nextLine();
        while (!command.equals("End")) {
            String[] input = command.split(" ");

            if (input[0].equals("Add")) {

                numbersList.add(Integer.valueOf(input[1]));
            } else if (input[0].equals("Remove")) {
                int indexR = Integer.parseInt(input[1]);
                if (indexR >= 0 && indexR <= numbersList.size() - 1) {
                    numbersList.remove(indexR);
                } else {

                    System.out.println("Invalid index");
                }
            } else if (input[0].equals("Insert")) {
                int index = Integer.parseInt(input[2]);
                int value = Integer.parseInt(input[1]);
                if (index >=0 && index <= numbersList.size() - 1) {
                    numbersList.add(index, value);
                } else {

                    System.out.println("Invalid index");
                }
            } else if (input[0].equals("Shift")) {
                if (input[1].equals("left")) {
                    int leftRange = Integer.parseInt(input[2]);
                    for (int i = 0; i < leftRange; i++) {
                        int indexed=0;
                        int leftElement = numbersList.get(indexed);
                        numbersList.add(leftElement);
                        numbersList.remove(numbersList.get(indexed));
                    }
                } else if (input[1].equals("right")) {
                    int rightRange = Integer.parseInt(input[2]);
                    for (int i = 0; i <rightRange; i++) {
                        int rightElement = numbersList.get(numbersList.size() - 1);
                        numbersList.add(0, rightElement);
                        numbersList.remove(numbersList.size() - 1);
                    }
                }
            }
            command = scann.nextLine();
        }

        for (int a:numbersList){
            System.out.print(a+" ");
        }
    }
}

