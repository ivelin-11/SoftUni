import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulatonAdvanced {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String[] input = scann.nextLine().split(" ");
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbersList.add(Integer.valueOf(input[i]));
        }
        String tempInput = scann.nextLine();


        while (!tempInput.equals("end")) {
            String[] charArray = tempInput.split(" ");
            if (charArray[0].equals("Contains")) {
                int number = Integer.parseInt(charArray[1]);
                if (numbersList.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            }

            if (charArray[0].equals("Print")) {
                if (charArray[1].equals("even")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) % 2 == 0) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }System.out.println();
                } else if (charArray[1].equals("odd")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) % 2 != 0) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }System.out.println();
                }
            }


            if (charArray[0].equals("Get")) {
                if (charArray[1].equals("sum")) {
                    int sum = 0;
                    for (int i = 0; i < numbersList.size(); i++) {
                        sum += numbersList.get(i);
                    }
                    System.out.println(sum);
                }
            }

            if (charArray[0].equals("Filter")) {
                int number = Integer.parseInt(charArray[2]);
                if (charArray[1].equals(">")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) > number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }System.out.println();
                } else if (charArray[1].equals("<")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) < number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }System.out.println();
                } else if (charArray[1].equals(">=")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) >= number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }System.out.println();
                } else if (charArray[1].equals("<=")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) <= number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }
                    System.out.println();
                }


            }
            tempInput = scann.nextLine();

        }

    }
}