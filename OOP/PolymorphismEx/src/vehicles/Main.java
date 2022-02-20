package vehicles;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        String[] input = scann.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2])+0.9);

        input = scann.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2])+1.6);

        int n = Integer.parseInt(scann.nextLine());

        while (n-- > 0) {
            input = scann.nextLine().split("\\s+");

            if (input[0].equals("Drive")) {

                double distance = Double.parseDouble(input[2]);

                if (input[1].equals("Car")) {
                    System.out.println(car.drive(distance));
                } else if (input[1].equals("Truck")) {
                    System.out.println(truck.drive(distance));
                }
            } else if (input[0].equals("Refuel")) {

                double fuel = Double.parseDouble(input[2]);

                if (input[1].equals("Car")) {
                    car.refuel(fuel);
                } else if (input[1].equals("Truck")) {
                    truck.refuel(fuel);
                }
            }
        }


        DecimalFormat df1=new DecimalFormat("##.00");
       // df1.setRoundingMode(RoundingMode.UP);
        System.out.printf("Car: %s%n",df1.format(car.getFuelQuantity()));
        System.out.printf("Truck: %s%n",df1.format(truck.getFuelQuantity()));

    }


}
