import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        String input= scann.nextLine();
        String[] arrayString=input.split(" ");
    int[] array=new int[arrayString.length];
    for(int i=0;i< array.length;i++){
        array[i]=Integer.parseInt(arrayString[i]);
    }
    int reverse=Integer.parseInt(scann.nextLine());
    for(int i=0;i<reverse;i++){
        for(int j=0;j< array.length-1;j++){
            int temp=array[j];
            array[j]=array[j+1];
            array[j+1]=temp;
        }
    }
    for(int a:array){
        System.out.print(a+" ");
    }
    }
}
