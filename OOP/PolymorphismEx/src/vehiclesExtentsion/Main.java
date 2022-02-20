package vehiclesExtentsion;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        String[] input = scann.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]) + 0.9, Double.parseDouble(input[3]));

        input = scann.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]) + 1.6,
                Double.parseDouble(input[3]));


        input = scann.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Double.parseDouble(input[3]));


        int n = Integer.parseInt(scann.nextLine());

        boolean isBusConsumptionIncreased=false;//to check bus if it is entered once and to help to set the
        //fuel Consumption depends on having people or no

        while (n-- > 0) {
            input = scann.nextLine().split("\\s+");

            if (input[0].equals("Drive")) {

                double distance = Double.parseDouble(input[2]);

                switch (input[1]) {
                    case "Car":
                        System.out.println(car.drive(distance));
                        break;
                    case "Truck":
                        System.out.println(truck.drive(distance));
                        break;
                    case "Bus":
                        if(!isBusConsumptionIncreased){
                            bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                            isBusConsumptionIncreased=true;
                        }
                        System.out.println(bus.drive(distance));
                        break;
                }


            } else if (input[0].equals("DriveEmpty")&&input[1].equals("Bus")){
                double distance = Double.parseDouble(input[2]);
                if(isBusConsumptionIncreased){
                    bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                    isBusConsumptionIncreased=false;
                }
                System.out.println(bus.drive(distance));
            }

            else if (input[0].equals("Refuel")) {

                double fuel = Double.parseDouble(input[2]);
try{
                switch (input[1]) {
                    case "Car":
                        car.refuel(fuel);
                        break;
                    case "Truck":
                        truck.refuel(fuel);
                        break;
                    case "Bus":

                       bus.refuel(fuel);
                        break;
                }
            }
catch (IllegalArgumentException e){
    System.out.println(e.getMessage());
}
            }

        }

        DecimalFormat df1 = new DecimalFormat("##.00");
        // df1.setRoundingMode(RoundingMode.UP);
        System.out.printf("Car: %s%n", df1.format(car.getFuelQuantity()));
        System.out.printf("Truck: %s%n", df1.format(truck.getFuelQuantity()));
        System.out.printf("Bus: %s%n", df1.format(bus.getFuelQuantity()));

    }
}
