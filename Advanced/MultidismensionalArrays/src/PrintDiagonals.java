import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());
        int[][] matrix=readMatrix(n,scann);

        int tempRow=0,tempCol=0;
        //print first diagonal
        while(tempRow<n&&tempCol<n){
            System.out.print(matrix[tempRow][tempCol]+" ");
            tempRow++;
            tempCol++;
        }
        System.out.println();
        tempRow=n-1;
        tempCol=0;
        while(tempRow>=0&&tempCol<n){
            System.out.print(matrix[tempRow][tempCol]+" ");
            tempRow--;
            tempCol++;
        }
    }
    private static int[][] readMatrix(int rows, Scanner scann) {
        int[][] matrix=new int[rows][];
        for(int r=0;r<rows;r++){
            matrix[r]= Arrays.stream(scann.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
