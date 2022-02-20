package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String[] tokens=scann.nextLine().split("\\s+");

        double pricePerDay=Double.parseDouble(tokens[0]);
        int days=Integer.parseInt(tokens[1]);
        String season=tokens[2];
        String discount=tokens[3];
        PriceCalculator priceCalculator=new PriceCalculator(pricePerDay,days,season,discount);
        System.out.printf("%.2f", priceCalculator.getTotalPrice());
    }
}
