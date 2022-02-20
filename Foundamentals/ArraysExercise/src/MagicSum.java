import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args){
        Scanner scann = new Scanner(System.in);
        String input= scann.nextLine();
        int number=Integer.parseInt(scann.nextLine());
        String[] stringArray=input.split(" ");
int[] sumArray= new int[stringArray.length];
for(int i=0;i<sumArray.length;i++){
    sumArray[i]=Integer.parseInt(stringArray[i]);
}
for(int i=0;i< sumArray.length;i++){
    for(int j=i+1;j< sumArray.length;j++){
if(sumArray[i]+sumArray[j]==number){
    System.out.printf("%d %d%n",sumArray[i],sumArray[j]);
}
    }
}
    }

}
