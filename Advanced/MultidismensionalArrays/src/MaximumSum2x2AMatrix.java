import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2x2AMatrix {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String[] size = scann.nextLine().split(", ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][];
        int[][] resultMatrix=new int[2][2];
        int maxSum = 0;
        matrix = readMatrix(rows, scann);
        for (int r = 0; r < rows - 1; r++) {

            for (int c = 0; c < matrix[r].length - 1; c++) {
                int currentElement=matrix[r][c];
                int rigthOfCurrent=matrix[r][c+1];
                int bottomOfCurrent=matrix[r+1][c];
                int rigthLeft=matrix[r+1][c+1];

                int currentSum=currentElement+rigthOfCurrent+bottomOfCurrent
                        +rigthLeft;
                if (currentSum > maxSum) {
                    maxSum=currentSum;
                   resultMatrix= new int[][]{
                           {currentElement, rigthOfCurrent},
                           {bottomOfCurrent, rigthLeft}
                   };
                }
            }

        }
        outputMatrix(resultMatrix);
        System.out.println(maxSum);
    }

    private static void outputMatrix(int[][] matrix) {
        for (int[] array:matrix) {
            for (int element:array) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
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
