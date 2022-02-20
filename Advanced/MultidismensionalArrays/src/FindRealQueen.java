import java.util.Scanner;

public class FindRealQueen {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        char[][] matrix =readMatrix(8,8,scann);


        for(int r=0;r<8;r++){
            int c=0;
           while(c<8){
                if(matrix[r][c]=='q'){
if(isRealQueen(matrix,r,c)){
    System.out.println(r+" "+c);
        return;
}
                }
                c++;
            }
        }

    }

    private static boolean isRealQueen(char[][] matrix, final int queenRows,final int queenCols) {
//iterating through each direction of the queen to check
        char queen=matrix[queenRows][queenCols];
         int rows=queenRows-1,cols=queenCols-1;

         //top left Diagonal
         while(rows>=0&&cols>=0){
             char current=matrix[rows][cols];
if(queen==current){
    return false;
}
             rows--;cols--;
         }


        //top(above) middle
rows=queenRows-1;cols=queenCols;
        while(rows>=0){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
            rows--;
        }

        //top right diagonal
        rows=queenRows-1;cols=queenCols+1;
        while(rows>=0&&cols<8){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
            rows--;cols++;
        }

        //middle right
        rows=queenRows;cols=queenCols+1;
        while(cols<8){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
          cols++;
        }

        //bottom right diagonal
        rows=queenRows+1;cols=queenCols+1;
        while(rows<8&&cols<8){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
            rows++;cols++;
        }

        //bottom middle
        rows=queenRows+1;cols=queenCols;
        while(rows<8){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
            rows++;
        }

        //bottom left diagonal
        rows=queenRows+1;cols=queenCols-1;
        while(rows<8&&cols>=0){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
            rows++;cols--;
        }

        //middle right
        rows=queenRows;cols=queenCols-1;
        while(cols>=0){
            char current=matrix[rows][cols];
            if(queen==current){
                return false;
            }
           cols--;
        }
        return true;
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
}
