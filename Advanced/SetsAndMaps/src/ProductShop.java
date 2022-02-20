import java.util.*;
public class ProductShop {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String input= scann.nextLine();
        Map<String,Map<String,Double>>shops=new TreeMap<>();

        while(!input.equals("Revision")){
            String[] tokens=input.split(", ");

String shopName=tokens[0];
String productName=tokens[1];
double price=Double.parseDouble(tokens[2]);

shops.putIfAbsent(shopName,new LinkedHashMap<>());
Map<String,Double> productsPrices=shops.get(shopName);
productsPrices.put(productName,price);

input= scann.nextLine();
        }

        for (Map.Entry<String,Map<String,Double>> entry:shops.entrySet()) {
            Map<String,Double> productsPrices=entry.getValue();
            System.out.printf("%s->%n",entry.getKey());
            for (Map.Entry<String,Double> secondEntry: productsPrices.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",
                        secondEntry.getKey(),secondEntry.getValue());
            }

        }
    }
}
