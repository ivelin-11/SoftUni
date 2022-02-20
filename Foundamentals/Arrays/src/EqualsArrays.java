import java.util.Scanner;

public class EqualsArrays {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);
       String input= scanner.nextLine();
       String[] arrayString_1=input.split(" ");
    String[] arrayString_2=scanner.nextLine().split(" ");
       int[] arrayInt_1=new int[arrayString_1.length];
       int[] arrayInt_2=new int[arrayString_2.length];
byte br=0;int sum=0;

       for(int i=0;i< arrayInt_1.length;i++){
           arrayInt_1[i]=Integer.parseInt(arrayString_1[i]);
       }
        for(int i=0;i< arrayInt_2.length;i++){
            arrayInt_2[i]=Integer.parseInt(arrayString_2[i]);
        }

        for(int i=0;i< arrayInt_1.length;i++){
            sum+=arrayInt_1[i];
            if(arrayInt_1[i]!=arrayInt_2[i]){
                br++;
                System.out.println("Arrays are not identical. Found difference at " + i+ " index.");
            break;
            }
        }

        if(br==0){
            System.out.println("Arrays are identical. Sum: "+sum);
        }
    }
}
