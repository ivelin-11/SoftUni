import java.util.Scanner;



public class AddAndSubstract {
    private static int sum(int a,int b){
      return a+b  ;
    }
    private static int substract(int a,int b){
        return b-a;
    }


    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);


        int firstNumber=Integer.parseInt(scann.nextLine());
        int secondNumber=Integer.parseInt(scann.nextLine());
        int thirdNumber=Integer.parseInt(scann.nextLine());

        int resultsOfSum=sum(firstNumber,secondNumber);
        int resultOfSubstract=substract(thirdNumber,resultsOfSum);
        System.out.println(resultOfSubstract);
    }
}
