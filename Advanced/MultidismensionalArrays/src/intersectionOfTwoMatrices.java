import java.util.Arrays;
import java.util.Scanner;

public class intersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        int rows=Integer.parseInt(scann.nextLine());
        int cols=Integer.parseInt(scann.nextLine());

        char[][] firstMatrix=readMatrix(rows,cols,scann);
        char[][] secondMatrix=readMatrix(rows,cols,scann);
        char[][] resultMatrix=new char[rows][cols];

        for(int r=0;r<rows;r++) {
            for (int c = 0; c < cols; c++) {
                resultMatrix[r][c] = firstMatrix[r][c] == secondMatrix[r][c] ?
                        firstMatrix[r][c] : '*';
            }
        }
        outputMatrix(resultMatrix);

    }

    private static char[][] readMatrix(int rows,int cols,Scanner scann) {
        char[][] matrix=new char[rows][cols];
        for(int r=0;r<rows;r++){
            String[] elements=scann.nextLine().split("\\s+");
        for(int c=0;c<cols;c++){
            matrix[r][c]=elements[c].charAt(0);
        }
        }
        return matrix;
    }
    private static void outputMatrix(char[][] matrix){
        for (char[] a:matrix) {
            for (char ch:a) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

}
