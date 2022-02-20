import java.util.Scanner;

public class MultiplyEvenByOdds {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int number=Integer.parseInt(scann.nextLine());
        int result=MultiplyEvenOdds(number);
        System.out.println(result);
    }

    private static int MultiplyEvenOdds(int number) {
    int evenSum=getEvenSum(number);
    int oddSum=getOddSum(number);

        return evenSum*oddSum;
    }

    private static int getOddSum(int number) {
        int sum=0;
        while(number!=0){
           int a=number%10;
           if(a%2==0){
               sum+=a;
           }
           number=number/10;
        }
        return sum;
    }

    private static int getEvenSum(int number) {
        int sum=0;
        while(number!=0){
            int a=number%10;
            if(a%2!=0){
                sum+=a;
            }
            number=number/10;
        }
        return sum;
    }
}
