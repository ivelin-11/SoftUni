import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossTtile {
    public static void main(String[] args) {
     Scanner scann=new Scanner(System.in);
     int n=Integer.parseInt(scann.nextLine());
     String regex="(?<name>[A-Z]{4,})\\|:\\#(?<title>[A-Z][a-z]+ \\w{1,})\\#";
     Pattern patter=Pattern.compile(regex);


     for(int i=0;i<n;i++){
         String input= scann.nextLine();
         Matcher matcher= patter.matcher(input);

         if(matcher.find()){

                 System.out.println(matcher.group("name")+", The "
                         +matcher.group("title"));
                 System.out.println(">> Strength: "+matcher.group("name").length());
                 System.out.println(">> Armor: "+matcher.group("title").length());

         }
         else{
             System.out.println("Access denied!");
         }

     }
    }
}
