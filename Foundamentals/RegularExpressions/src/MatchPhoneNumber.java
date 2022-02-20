import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        String phonesList= scann.nextLine();
        String pattern="\\+359([ -])2\\1(\\d{3})\\1\\d{4}\\b";
        Pattern regex=Pattern.compile(pattern);
        Matcher matcher= regex.matcher(phonesList);
List<String> list=new ArrayList<>();
        while(matcher.find()){
            list.add(matcher.group());
        }

        System.out.println(String.join(", ",list));
    }
}
