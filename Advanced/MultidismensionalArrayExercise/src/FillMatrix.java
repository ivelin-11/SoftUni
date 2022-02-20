import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);


        String[] input=scann.nextLine().split(", ");

        int size=Integer.parseInt(input[0]);
        String pattern= input[1];

        int[][] matrix=new int[size][];

        if(pattern.equals("A")){
            matrix=getFirstPattern(size);
        }
        else if(pattern.equals("B")){
matrix=getSecondPattern(size);
        }

        printMatrix(matrix);


    }
    private static void printMatrix(int[][] outputMatrix) {
        for (int[] matrix : outputMatrix) {
            for (int number : matrix) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
    private static int[][] getSecondPattern(int size) {
        int[][] matrix=new int[size][size];
        int counter=1;int cols=0;
        while(cols<size){
            if(cols%2==0){
                for(int i=0;i<size;i++){
                    matrix[i][cols]=counter;
                    counter++;
                }
                cols++;
            }
            else{
                int temp=size-1;
                while(temp>=0){
                    matrix[temp][cols]=counter;
                    counter++;
                    temp--;
                }
                cols++;
            }

        }


        return matrix;
    }

    private static int[][] getFirstPattern(int size) {
        int[][] matrix=new int[size][size];
int counter=1;int cols=0;
        while(cols<size){
            for(int i=0;i<size;i++){
                matrix[i][cols]=counter;
                counter++;

            }
           cols++;
        }


        return matrix;
    }

}
