import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String[] bannedWords=scann.nextLine().split(", ");
        String text= scann.nextLine();
String temp="";
        for(int i=0;i< bannedWords.length;i++){
           temp="";
            for(int j=0;j<bannedWords[i].length();j++){
            temp+="*";
            }
            text=text.replace(bannedWords[i],temp );
        }
        System.out.println(text);
    }
}
