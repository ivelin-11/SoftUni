import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int firstNumber=Integer.parseInt(scann.nextLine());
        int secondNumber=Integer.parseInt(scann.nextLine());
        int thirdNumber=Integer.parseInt(scann.nextLine());
        int smallestNumber=DefineSmallestNumber(firstNumber,secondNumber,thirdNumber);
        System.out.println(smallestNumber);

    }

    private static int DefineSmallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
    if(firstNumber<=secondNumber&&firstNumber<=thirdNumber){
        return firstNumber;
    }
    else if(secondNumber<=firstNumber&&secondNumber<=thirdNumber){
        return  secondNumber;
    }
    else if(thirdNumber<=firstNumber&&thirdNumber<=secondNumber){
        return  thirdNumber;
    }

    return 0;
    }
}
