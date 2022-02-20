import java.util.Scanner;

public class CaeserCipher {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String text= scann.nextLine();
        StringBuilder newText=new StringBuilder();
        for(int i=0;i<text.length();i++){
            char current=text.charAt(i);
            int oldValue=(int) current;
            int newValue=oldValue+3;
            char newChar=(char) newValue;

            newText.append(newChar);
        }
        System.out.println(newText);
    }
}
