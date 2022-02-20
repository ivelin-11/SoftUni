import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size=Integer.parseInt(scanner.nextLine());
        int[][] matrix=inputMatrix(scanner,size,"\\s+");

        int rows=0,cols=0,primarySum=0,secondarySum=0;

        while(rows<size&&cols<size){
            primarySum+=matrix[rows][cols];
            rows++;cols++;
        }
        rows=size-1;cols=0;
        while(rows>=0&&cols<size){
            secondarySum+=matrix[rows][cols];
            rows--;cols++;
        }
        System.out.println(Math.abs(primarySum - secondarySum));

    }
    private static int[][] inputMatrix(Scanner scanner, int rows, String pattern) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
