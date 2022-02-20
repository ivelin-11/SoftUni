import java.util.*;
import java.util.stream.Collectors;

public class StringMatrixRotaton {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

String command= scann.nextLine();
int degrees=Integer.parseInt(
        command.substring(7,command.length()-1));

command= scann.nextLine();
        List<String> matrixList=new ArrayList<>();int cols=0;
while(!command.equals("END")){

    if(cols<command.length()){
        cols=command.length();
    }
   matrixList.add(command);
    command= scann.nextLine();
}
int rows=matrixList.size();
        char[][] matrix=new char[rows][];
        int index=0;
while(!matrixList.isEmpty()){

    int counterArray=0;//count the array
    char[] b=new char[cols];
    while(counterArray<matrixList.get(0).length()){
        b[counterArray]=matrixList.get(0).charAt(counterArray);
        counterArray++;
    }
    while(counterArray<b.length){
        b[counterArray]=' ';
        counterArray++;
    }
    matrix[index]=b;
    index++;
    matrixList.remove(0);
}
printMatrix(matrix,degrees);
        System.out.println();
    }



    private static void printMatrix(char[][] outputMatrix,int degrees) {
        while(degrees>360){
            degrees-=360;
        }

        if(degrees==90){
            int newRows= 0;

           while(newRows<outputMatrix[0].length){
               int newCols=outputMatrix.length-1;

               while (newCols>=0){
                   System.out.print(outputMatrix[newCols][newRows]);
                   newCols--;
               }
               newRows++;
               System.out.println();
           }
        }
else if(degrees==180){
    int rows= outputMatrix.length-1;
           while (rows>=0) {
                char[] a=outputMatrix[rows];
                int i=outputMatrix[0].length-1;
              while(i>=0){
                  System.out.print(a[i]);
                  i--;
              }
              rows--;
                System.out.println();
            }
        }
else if(degrees==270){
    int newRows=outputMatrix[0].length-1;
    while(newRows>=0){
        int newCols=0;
        while(newCols<outputMatrix.length){
            System.out.print(outputMatrix[newCols][newRows]);
            newCols++;
        }
        System.out.println();
        newRows--;
    }
        }
else if(degrees==360||degrees==0){
            for (char[] matrix : outputMatrix) {
                for (char number : matrix) {
                    System.out.print(number);
                }
                System.out.println();
            }
        }
    }


}
