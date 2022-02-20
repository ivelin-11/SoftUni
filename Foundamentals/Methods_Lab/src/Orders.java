import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String productName= scann.nextLine();
        int productQuantity= Integer.parseInt(scann.nextLine());

        double coffeePrice=1.50;
        double waterPrice=1.00;
        double cokePrice=1.40;
        double snacksPrice=2.00;

        if(productName.equals("coffee")){
            getTotalPrice(coffeePrice,productQuantity);
        }
        else if ((productName.equals("water"))){
            getTotalPrice(waterPrice,productQuantity);
        }
        else if ((productName.equals("coke"))){
            getTotalPrice(cokePrice,productQuantity);
        }
        else if ((productName.equals("snacks"))){
            getTotalPrice(snacksPrice,productQuantity);
        }
    }
    public static void getTotalPrice(double price,int amount){
        double totalPrice=price*amount;
        System.out.printf("%.2f",totalPrice);
    }
}
