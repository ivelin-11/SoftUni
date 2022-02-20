import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterInRange {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        char firstChar=scann.next().charAt(0);
        char secondChar=scann.next().charAt(0);
        List<String>  result= new ArrayList<>();
        printChars(firstChar,secondChar,result);
        for (String a:result) {
            System.out.print(a+" ");
        }
    }

    private static void  printChars(char firstChar, char secondChar,List <String> result) {
    int firstIndex=(int) firstChar;
    int secondIndex=(int) secondChar;

    if(firstIndex<secondIndex){
        for(int i=firstIndex+1;i<secondIndex;i++){
            char temp=(char) i;

            result.add( String.valueOf(temp));
        }
    }
    if(secondIndex<firstIndex){
        for(int i=secondIndex+1;i<firstIndex;i++){
            char temp=(char) i;

            result.add( String.valueOf(temp));
        }
    }


    }
}
