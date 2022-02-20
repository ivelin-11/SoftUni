import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String[] size = scann.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        int[][] resultMatrix=new int[3][3];
        int maxSum = 0;
        matrix = readMatrix(rows, scann);
        for (int r = 0; r < rows - 2; r++) {

            for (int c = 0; c < matrix[r].length - 2; c++) {
                int currentElement=matrix[r][c];
                int rigthOfCurrent=matrix[r][c+1];
                int rigthest=matrix[r][c+2];
                int sumFirstLine=currentElement+rigthOfCurrent+rigthest;

                int bottomOfCurrent=matrix[r+1][c];
                int rigthOfBottom=matrix[r+1][c+1];
                int righthestBottom=matrix[r+1][c+2];
                int sumSecondLine=bottomOfCurrent+rigthOfBottom+righthestBottom;

                int last=matrix[r+2][c];
                int rigthLast=matrix[r+2][c+1];
                int rigthestLast=matrix[r+2][c+2];
                int ThirdLine=last+rigthLast+rigthestLast;

                int currentSum=sumFirstLine+sumSecondLine+ThirdLine;

                if (currentSum > maxSum) {
                    maxSum=currentSum;
                    resultMatrix= new int[][]{
                            {currentElement, rigthOfCurrent,rigthest},
                            {bottomOfCurrent, rigthOfBottom,righthestBottom},
                            {last,rigthLast,rigthestLast}
                    };
                }
            }

        }
        System.out.println("Sum = "+maxSum);
        outputMatrix(resultMatrix);

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
            matrix[r]= Arrays.stream(scann.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
