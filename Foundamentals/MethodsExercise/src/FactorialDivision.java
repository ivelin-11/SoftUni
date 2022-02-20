import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);

        long firstNumber=Integer.parseInt(scann.nextLine());
        long secondNumber=Integer.parseInt(scann.nextLine());

        double ResultFirstFactoriel=firstFactoriel(firstNumber);
        double ResultSecondFactoriel=secondFactoriel(secondNumber);
        double ResultDivision= ResultFirstFactoriel/ResultSecondFactoriel;
        System.out.printf("%.2f",ResultDivision);
    }




    private static double secondFactoriel(long secondNumber) {
        long factoriel=1;
        for(int i=1;i<=secondNumber;i++){
            factoriel=factoriel*i;
        }
        return factoriel;
    }

    private static double firstFactoriel(long firstNumber) {
        long factoriel=1;
        for(int i=1;i<=firstNumber;i++){
            factoriel=factoriel*i;
        }
        return factoriel;
    }
}
