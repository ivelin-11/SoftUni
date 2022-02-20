import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
String[] input= scann.nextLine().split(", ");

List<String> correctNames=new ArrayList<>();
for(int i=0;i<input.length;i++){
    boolean a=false;
    a=checkIfItIsCorrect(input[i]);
    if(a){
        correctNames.add(input[i]);
    }

}

        for (String b:correctNames){
            System.out.println(b);
        }
    }

    private static boolean checkIfItIsCorrect(String s) {
        boolean w=false;
        if(s.length()>=3&&s.length()<=16){
            w=true;
            for(char symbol:s.toCharArray()){
                if(Character.isLetterOrDigit(symbol)||symbol=='-'||symbol=='_'){

                }
                else{
                 return false;
                }
            }
        }
        return w;
    }
}
