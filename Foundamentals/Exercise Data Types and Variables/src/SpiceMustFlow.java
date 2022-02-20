import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int startYield=Integer.parseInt(scanner.nextLine());
       int days=0,yields=0, totalAmount =0;
        while(startYield>=100){

         yields=startYield-26;
         totalAmount +=yields;
            startYield-=10;
            days++;
        }
        System.out.println(days);
        if(totalAmount>=26){
            System.out.println(totalAmount-26);
        }
        else{
            System.out.println(totalAmount);
        }

    }
}
