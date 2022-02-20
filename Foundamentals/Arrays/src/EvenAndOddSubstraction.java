import java.util.Scanner;

public class EvenAndOddSubstraction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] arrayString=input.split(" ");
        int[] arrayInt=new int[arrayString.length];
        for(int i=0;i< arrayInt.length;i++){
            arrayInt[i]=Integer.parseInt(arrayString[i]);
        }

        int sumEven=0,sumOdd=0;
        for(int i=0;i< arrayInt.length;i++){
            if(arrayInt[i]%2==0){
               sumEven+=arrayInt[i];
            }
            else if(arrayInt[i]%2!=0){
                sumOdd+=arrayInt[i];
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
