import java.util.Scanner;

public class DigitsLetters {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

String input= scann.nextLine();
StringBuilder digits=new StringBuilder();
        StringBuilder letters=new StringBuilder();
        StringBuilder others=new StringBuilder();
   for(int i=0;i<input.length();i++){
     char currentSymbol=input.charAt(i);
     if((currentSymbol>=32&&currentSymbol<=47)
     ||(currentSymbol>=58&&currentSymbol<=64)
     ||(currentSymbol>=91&&currentSymbol<=96)
             ||(currentSymbol>=123&&currentSymbol<=127)){
         others.append(currentSymbol);
     }
     else if(currentSymbol>=48&&currentSymbol<=57){
         digits.append(currentSymbol);
     }
     else if((currentSymbol>=65&&currentSymbol<=90)
             ||(currentSymbol>=97&&currentSymbol<=122)){
         letters.append(currentSymbol);
     }

   }

        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(others.toString());
    }
}
