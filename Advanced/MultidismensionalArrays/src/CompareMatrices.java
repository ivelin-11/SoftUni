import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String[] input = scann.nextLine().split("\\s++");
        int rows=Integer.parseInt(input[0]) ;
        int[][] firstMatrix = readMatrix(rows, scann);

        input = scann.nextLine().split("\\s++");
         rows=Integer.parseInt(input[0]) ;
        int[][] secondMatrix = readMatrix(rows, scann);
        boolean areEquals=areEquals(firstMatrix,secondMatrix);
        String result=areEquals?"equal":"not equal";
        System.out.println(result);

    }

    private static boolean areEquals(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length!= secondMatrix.length){
            return false;
        }
int row=0;
        int col=0;

        while(row< secondMatrix.length){
            col=0;
            if(firstMatrix[row].length!=secondMatrix[row].length){
                return false;
            }
            while(col<secondMatrix[row].length){
                int first=firstMatrix[row][col];
                int second=secondMatrix[row][col];
                if(first!=second){
                    return false;
                }
                col++;
            }
            row++;
        }
        return true;

    }

    private static int[][] readMatrix(int rows, Scanner scann) {
        int[][] matrix =new int[rows][];

        for(int row=0;row<rows;row++){
            matrix[row]=Arrays.stream(scann.nextLine().split("\\s++"))
                            .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
