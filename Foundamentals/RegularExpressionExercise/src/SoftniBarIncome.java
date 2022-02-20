import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftniBarIncome {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        String input= scann.nextLine();double totalIncome=0;
        String regex="%(?<customer>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<quantity>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+.?[0-9]*)\\$";
Pattern pattern= Pattern.compile(regex);
Map <String, List<String>>Incomes=new LinkedHashMap<>();
        while(!input.equals("end of shift")){
            Matcher matcher= pattern.matcher(input);
            if(matcher.find()){
                String customerName=matcher.group("customer");
                        String product= matcher.group("product");
                int count=Integer.parseInt(matcher.group("quantity"));
                double price=Double.parseDouble(matcher.group("price"));
               double totalPrice=count*price;
                System.out.printf("%s: %s - %.2f%n",customerName,product,totalPrice);
                totalIncome+=totalPrice;
            }

            input= scann.nextLine();
        }

        System.out.printf("Total income: %.2f",totalIncome);

    }
}
