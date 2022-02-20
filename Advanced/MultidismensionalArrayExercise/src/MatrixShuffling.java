import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String[] cordinates=scann.nextLine().split("\\s+");
        int rows=Integer.parseInt(cordinates[0]);
        int cols=Integer.parseInt(cordinates[1]);

        String[][] matrix=inputMatrix(scann,rows,"\\s+");

        String command= scann.nextLine();
while(!command.equals("END")){
    String[] searchCordinates=command.split("\\s+");
    if(searchCordinates[0].equals("swap")&&searchCordinates.length==5){

        int r1=Integer.parseInt(searchCordinates[1]);
        int c1=Integer.parseInt(searchCordinates[2]);
        int r2=Integer.parseInt(searchCordinates[3]);
        int c2=Integer.parseInt(searchCordinates[4]);

        if( (checkIndex(r1,c1,rows,cols))&&
                (checkIndex(r2,c2,rows,cols))){
            String oldValue=matrix[r1][c1];
            matrix[r1][c1]=matrix[r2][c2];
            matrix[r2][c2]=oldValue;
            printMatrix(matrix);
        }
        else{
            System.out.println("Invalid input!");
        }

    }
    else{
        System.out.println("Invalid input!");
    }

    command= scann.nextLine();
}
    }

    private static boolean checkIndex(int r,int c,int rows,int cols) {
        if((r>=0&&r<rows)&&(c>=0&&c<cols)){
            return true;
        }
        return false;
    }

    private static void printMatrix(String[][] outputMatrix) {
        for (String[] matrix : outputMatrix) {
            for (String number : matrix) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static String[][] inputMatrix(Scanner scanner, int rows, String pattern) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
