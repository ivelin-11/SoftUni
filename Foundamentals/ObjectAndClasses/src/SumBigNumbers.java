import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {




        public static void main(String[] args) {
            Scanner scann = new Scanner(System.in);
           BigInteger firstNumber= new BigInteger(scann.nextLine());
            BigInteger secondNumber= new BigInteger(scann.nextLine());
            System.out.println(firstNumber.add(secondNumber));
        }
    }


