import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);

        String input= scann.nextLine();

        String result=middleCharacter(input);
        System.out.println(result);
    }

    private static String middleCharacter(String input) {
        for(int i=0;i<input.length();i++){
            if(i==input.length()/2){
               if(input.length()%2==0){
                   String a= String.valueOf(input.charAt(i-1));
                   String b=String.valueOf(input.charAt(i));
                   return a+b;
               }
               else {
                   return String.valueOf(input.charAt(i));
               }
            }
        }
        return "";
    }
}

