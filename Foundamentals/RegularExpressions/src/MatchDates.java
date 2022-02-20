import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String dates= scann.nextLine();
        String pattern="(?<dayName>[0-9][0-9])([.\\-/])(?<monthName>[A-Z][a-z]{2})\\2(?<year>\\d{4})";

        Pattern regex=Pattern.compile(pattern);
        Matcher matcher= regex.matcher(dates);

        while(matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",matcher.group(1),
                    matcher.group(3),matcher.group(4));
        }
    }
}
