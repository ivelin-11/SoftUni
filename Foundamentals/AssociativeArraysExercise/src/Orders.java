import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

String[] input=scann.nextLine().split(" ");
        Map<String, List<Double>> products=new LinkedHashMap<>();
        List<String> productNames=new ArrayList<>();
       double quantity =0.00,price=0.00;

while(!input[0].equals("buy")){
    price=Double.parseDouble(input[1]);
    quantity=Double.parseDouble(input[2]);


if(!products.containsKey(input[0])){
    List <Double> priceQuantity=new ArrayList<>();
    priceQuantity.add(price);priceQuantity.add(quantity);
    priceQuantity.add(price*quantity);
    products.put(input[0],priceQuantity);productNames.add(input[0]);
}
else{
    List <Double> priceQuantity=products.get(input[0]);
    double oldQuantity=priceQuantity.get(1);
    priceQuantity.set(0,price);priceQuantity.set(1,oldQuantity+quantity);
    priceQuantity.set(2,price*(oldQuantity+quantity));
    products.put(input[0],priceQuantity);
}


    input=scann.nextLine().split(" ");
}
int i=0;
        for (Map.Entry<String,List<Double>> entry:products.entrySet()) {
            List <Double> priceQuantity=products.get(productNames.get(i));

            System.out.printf(entry.getKey()+" -> %.2f%n",priceQuantity.get(2));
            i++;
        }

    }
}
