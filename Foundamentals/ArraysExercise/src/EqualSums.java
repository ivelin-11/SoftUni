import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        String input= scann.nextLine();
        String[] stringArray=input.split(" ");
        int[] array=new int[stringArray.length];
       boolean a=false;
        for(int i=0;i< array.length;i++){
            array[i]=Integer.parseInt(stringArray[i]);
        }
        for(int i=0;i< array.length;i++){
          int leftSum=0;
          int rigthSum=0;
          for(int j=0;j< i;j++){
              leftSum+=array[j];
          }
            for(int k=i+1;k<=array.length-1;k++){
                rigthSum+=array[k];
            }
            if(leftSum==rigthSum){
                a=true;
                System.out.println(i);
                break;
            }

        }
        if(!a){
            System.out.println("no");

        }
    }
}
