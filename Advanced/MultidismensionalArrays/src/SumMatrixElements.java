import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        String[] sizes=scann.nextLine().split(", ");
        int rows=Integer.parseInt(sizes[0]);
int cols=Integer.parseInt(sizes[1]);



int sum=0;
        int[][] firstMatrix=readMatrix(rows,scann);
        for(int i=0;i< firstMatrix.length;i++){
            sum+=Arrays.stream(firstMatrix[i]).sum();
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[][] readMatrix(int rows, Scanner scann) {
        int[][] matrix=new int[rows][];
        for(int r=0;r<rows;r++){
            matrix[r]= Arrays.stream(scann.nextLine().split(", ")).
                    mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
