import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
String input= scann.nextLine();
String regex="[\\\\>]{2}(?<furniture>[A-Za-z]+)[\\\\<]{2}(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]*)";
Pattern pattern= Pattern.compile(regex);

        List<String> furnitureList=new ArrayList<>();
        double totalMOmey=0;
        while(!input.equals("Purchase")){
            Matcher matcher= pattern.matcher(input);
            if(matcher.find()){
                String furniture= matcher.group("furniture");
                double price=Double.parseDouble(matcher.group("price"));
                int quantity=Integer.parseInt(matcher.group("quantity"));
                furnitureList.add(furniture);
                double currentPrice=price*quantity;
                totalMOmey+=currentPrice;
            }


            input= scann.nextLine();
        }
        System.out.println("Bought furniture: ");
        for (String a:furnitureList
             ) {
            System.out.println(a);
        }
        System.out.printf("Total money spend: %.2f",totalMOmey);

    }
}
