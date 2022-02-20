import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String name= scann.nextLine();
        String pattern="\\b[A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+\\b";

        Pattern regex=Pattern.compile(pattern);
        Matcher matcher= regex.matcher(name);

        while (matcher.find()){
            System.out.print(matcher.group()+" ");
        }
    }
}
