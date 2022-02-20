import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        int rows=Integer.parseInt(scann.nextLine());
        int[][] matrix=readMatrix(rows,scann);
        String[] coordinatesOfRemovingElement= scann.nextLine().split("\\s+");

        int rowOfRemovingElement=Integer.parseInt(coordinatesOfRemovingElement[0]);
        int colOfRemovingElement=Integer.parseInt(coordinatesOfRemovingElement[1]);

        int elementToRemove=matrix[rowOfRemovingElement][colOfRemovingElement];

        //we create the storage because newNumbers set don't include in the sum
        //we don't use map because there can be one unique key

        //and values which don't have correct neighbours are having sum=0;!!!!!
        ArrayDeque<Integer> storageNewValues=new ArrayDeque<>();

        int r=0;
        while(r<rows){
            for(int col=0;col<matrix[r].length;col++){
                if(matrix[r][col]==elementToRemove){
                    int newNumber=getNewNumber(matrix,r,col,elementToRemove);
                    //put value and his indexes into queue
                    storageNewValues.offer(newNumber);
                    storageNewValues.offer(r);
                    storageNewValues.offer(col);
                }
            }
            r++;
        }



        //set the new numbers
      while(!storageNewValues.isEmpty())
            //cordinates of new value are the same with old one ;)
          if(!storageNewValues.isEmpty()){
              int newElement=storageNewValues.poll();
              int rowsOfNewValue=storageNewValues.poll();
              int colOfNewValue=storageNewValues.poll();
              matrix[rowsOfNewValue][colOfNewValue]=newElement;
          }





        outputMatrix(matrix);

    }

    private static int getNewNumber(int[][] matrix, int row, int col,int elementToRemove) {
        int sum=0;
        //check cordinates of neighbouring elemets if they are valid and if they are we sum them
        int top=row-1;
        int bottom=row+1;
        int left=col-1;
        int right=col+1;


        /*second check in the if is for correct cols of the top line
        which protect againstIndexOutOfBoounds
         */
        if(top>=0&&top< matrix.length&&col<matrix[top].length){
            if(matrix[top][col]!=elementToRemove){
                sum+=matrix[top][col];
            }

        }

        /*second check in the if is for correct cols of the bottom line
        which protect againstIndexOutOfBoounds
         */
        if(bottom>=0&&bottom< matrix.length&&col<matrix[bottom].length){

            if(matrix[bottom][col]!=elementToRemove){
                sum+=matrix[bottom][col];
            }

        }
        if(left>=0&&left<matrix[row].length&&matrix[row][left]!=elementToRemove){
            sum+=matrix[row][left];
        }
        if(right>=0&&right<matrix[row].length&&matrix[row][right]!=elementToRemove){
            sum+=matrix[row][right];
        }
        return  sum;
    }

    private static int[][] readMatrix(int rows, Scanner scann) {
        int[][] matrix=new int[rows][];

        for(int r=0;r<rows;r++){
            matrix[r]=Arrays.stream(scann.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
    private static void outputMatrix(int[][] matrix) {
        for (int[] array:matrix) {
            for (int element:array) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
