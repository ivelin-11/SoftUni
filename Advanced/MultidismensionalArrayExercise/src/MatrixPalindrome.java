import java.util.Scanner;

public class MatrixPalindrome {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];


        for (int r = 1; r <= rows; r++) {
            String beginEnd = getLetter(r);
            int counter = r;//counter for letters
            for (int c = 1; c <= cols; c++) {
                String middle = getLetter(counter);
                matrix[r - 1][c - 1] = beginEnd + middle + beginEnd;
                counter++;
            }


        }
        printMatrix(matrix);
    }


    private static void printMatrix(String[][] outputMatrix) {
        for (String[] matrix : outputMatrix) {
            for (String number : matrix) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static String getLetter(int symbol) {
        switch (symbol) {
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            case 4:
                return "d";
            case 5:
                return "e";
            case 6:
                return "f";
            case 7:
                return "g";
            case 8:
                return "h";
            case 9:
                return "i";
            case 10:
                return "j";
            case 11:
                return "k";
            case 12:
                return "l";
            case 13:
                return "m";
            case 14:
                return "n";
            case 15:
                return "o";
            case 16:
                return "p";
            case 17:
                return "q";
            case 18:
                return "r";
            case 19:
                return "s";
            case 20:
                return "t";
            case 21:
                return "u";
            case 22:
                return "v";
            case 23:
                return "w";
            case 24:
                return "x";
            case 25:
                return "y";
            case 26:
                return "z";
            default:
                return "error";
        }
    }
}



