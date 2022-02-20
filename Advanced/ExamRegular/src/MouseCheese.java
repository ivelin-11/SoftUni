import java.util.Scanner;

public class MouseCheese {
    static int startRow = 0, startCol = 0, cheeseCounter = 0;

    public static void main(String[] args) {

        Scanner scann = new Scanner((System.in));

        int n = Integer.parseInt(scann.nextLine());
        char[][] matrix = new char[n][n];

        for (int r = 0; r < matrix.length; r++) {
            String line = scann.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("M")) {
                startRow = r;
                startCol = line.indexOf('M');
            }
        }
        StringBuilder output = new StringBuilder();

        boolean isInside = true;
        while (isInside) {
            String command = scann.nextLine();
            if(command.equals("end")){
                break;
            }
            else if (command.equals("up")) {
                isInside = move(matrix, startRow - 1, startCol,command);
            } else if (command.equals("down")) {
                isInside = move(matrix, startRow + 1, startCol,command);
            } else if (command.equals("left")) {
                isInside = move(matrix, startRow, startCol - 1,command);
            } else if (command.equals("right")) {
                isInside = move(matrix, startRow, startCol + 1,command);
            }

        }

        if (!isInside) {
            output.append("Where is the mouse?").append("\n");
        }

        if(cheeseCounter>=5){
            output.append(String.format("Great job, the mouse is fed %d cheeses!",
                    cheeseCounter));
        }
        else{
            output.append(String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.",
                    5-cheeseCounter));
        }
        System.out.println(output.toString());
        printMatrix(matrix);
    }

    private static boolean move(char[][] matrix, int newRow, int newCol,String command) {
        matrix[startRow][startCol] = '-';
        if (outOfBounds(matrix, newRow, newCol)) {
            return false;
        }
        if(matrix[newRow][newCol]=='B'){
            matrix[newRow][newCol]='-';
            int []a=new int [2];
            a=getPositionBonus(newRow,newCol,command);
            newRow=a[0];newCol=a[1];
        }
        if (outOfBounds(matrix, newRow, newCol)) {
            return false;
        }
if(matrix[newRow][newCol]=='c'){
    cheeseCounter++;
}



        matrix[newRow][newCol] = 'M';
        startRow = newRow;
        startCol = newCol;

        return true;
    }
    private static int[] getPositionBonus( int newRow, int newCol,String command) {
        int [] b=new int[2];
        if(command.equals("up")){
            b[0]=newRow-1;b[1]=newCol;
        }
        else if(command.equals("down")){
            b[0]=newRow+1;b[1]=newCol;
        }
        else if(command.equals("right")){
            b[0]=newRow; b[1]=newCol+1;
        }
        else if(command.equals("left")){
            b[0]=newRow; b[1]=newCol-1;
        }
        return b;
    }
    private static boolean outOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >=matrix[r].length;
    }
    private static void printMatrix(char[][] outputMatrix) {
        for (char[] matrix : outputMatrix) {
            for (char number : matrix) {
                System.out.print(number + "");
            }
            System.out.println();
        }
    }
}
