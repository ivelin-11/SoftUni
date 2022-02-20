import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        String[] arrayString_1=input.split(" ");
        int[] arrayInt_1=new int[arrayString_1.length];
        for(int i=0;i< arrayInt_1.length;i++){
            arrayInt_1[i]=Integer.parseInt(arrayString_1[i]);
        }


        while(arrayInt_1.length>1){
            int[] condensed=new int[arrayInt_1.length-1];
            for(int i=0;i< arrayInt_1.length-1;i++){
                condensed[i]=arrayInt_1[i]+arrayInt_1[i+1];
        }
arrayInt_1=condensed;
        }
        System.out.println(arrayInt_1[0]);

    }
}
