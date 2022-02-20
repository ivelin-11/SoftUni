import java.util.Scanner;
public class SumEvenNumbers {
    public static void main(String[] args){
       Scanner scanner=new Scanner(System.in);
       String input = scanner.nextLine();
       String[] arrayString=input.split(" ");
       int[] arrayInt= new int[arrayString.length];
       for(int i=0;i<arrayString.length;i++){
           arrayInt[i]=Integer.parseInt(arrayString[i]);
       }
       int sum=0;
       for(int i=0;i< arrayInt.length;i++){
           if(arrayInt[i]%2==0){
               sum+=arrayInt[i];
           }
       }
        System.out.println(sum);


    }

}
