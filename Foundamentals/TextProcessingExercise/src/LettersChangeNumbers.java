import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String input = scann.nextLine();
        String[] passwords = input.split("\\s+");
        double sum = 0;
        for (String password : passwords) {
            double currentSum = getCurrentSum(password);
            sum += currentSum;
        }
        System.out.printf("%.2f", sum);
    }

    private static double getCurrentSum(String password) {
        double sum=0;
        char firstLetter = password.charAt(0);
        char secondLetter = password.charAt(password.length() - 1);
        StringBuilder builder =new StringBuilder(password);
        double number = Double.parseDouble(builder.deleteCharAt(0).deleteCharAt(builder.length()-1).toString());

        if(Character.isUpperCase(firstLetter)){
            int positionUpperLetter=(int) firstLetter-64;
            number=number/positionUpperLetter;


    }
        else{
            int positionLowerLetter=(int) firstLetter-96;
            number=number*positionLowerLetter;

        }

        if(Character.isUpperCase(secondLetter)){
            int positionUpperLetter=(int) secondLetter-64;
            number=number-positionUpperLetter;

        }
        else{
            int positionLowerLetter=(int) secondLetter-96;
            number=number+positionLowerLetter;

        }

        return number;
    }

}
