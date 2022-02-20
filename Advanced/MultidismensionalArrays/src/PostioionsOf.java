import java.util.Arrays;
import java.util.Scanner;

public class PostioionsOf {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        int rows=Integer.parseInt(scann.nextLine().split("\\s+")[0]);
   int[][] matrix=new int[rows][];

   for(int row=0;row<rows;row++){
       matrix[row]=
               Arrays.stream(scann.nextLine().split("\\s+"))
                       .mapToInt(Integer::parseInt).toArray();
   }

   int searchedNumber=Integer.parseInt(scann.nextLine());
   boolean isFound=false;

   for(int row=0;row<rows;row++){
       for(int col=0;col<matrix[row].length;col++){
           if(matrix[row][col]==searchedNumber){
               System.out.println(row+" "+col);
               isFound=true;
           }
       }
   }
if(!isFound){
    System.out.println("not found");
}
    }
}
