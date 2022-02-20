import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String command= scann.nextLine();
        if(command.equals("int")){
         int firstNumber=Integer.parseInt(scann.nextLine()),
                 secondNumber=Integer.parseInt(scann.nextLine());
         int result=getMax(firstNumber,secondNumber);
            System.out.println(result);
        }
        else if (command.equals("char")){
            char firstSymbol=scann.next().charAt(0);
                    char secondSymbol=scann.next().charAt(0);
            char result=getMax(firstSymbol,secondSymbol);
            System.out.println(result);
        }
        else if(command.equals("string")){
String word1= scann.nextLine();
String word2= scann.nextLine();
String result=getMax(word1,word2);
            System.out.println(result);
        }
    }

   static int getMax(int firstNumber, int secondNumber) {
        if(firstNumber>=secondNumber){
            return firstNumber;
        }
        else{
            return secondNumber;
        }
    }
     static char getMax(char first, char second) {
        if(first >= second){
            return first;
        }
        else{
            return second;
        }
    }
    private static String getMax(String firstSymbol, String secondSymbol) {
        if(firstSymbol.compareTo(secondSymbol)>=0){
            return firstSymbol;
        }
        else{
            return secondSymbol;
        }
    }

}
