import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
   int n=Integer.parseInt(scann.nextLine());
   int[] array1=new int[n];
   int[] array2=new int[n];
   for(int i=0;i<n;i++){
       if(i%2==0){
           array1[i]=Integer.parseInt(scann.next());
           array2[i]=Integer.parseInt(scann.next());

       }
       if(i%2!=0){
           array2[i]=Integer.parseInt(scann.next());
           array1[i]=Integer.parseInt(scann.next());

       }
   }
   for(int b:array1){
       System.out.print(b+" ");
   }
        System.out.println();
        for(int c:array2){
            System.out.print(c+" ");
        }
    }
}
