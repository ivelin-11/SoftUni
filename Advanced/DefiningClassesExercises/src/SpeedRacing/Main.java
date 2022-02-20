package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String,Car> cars=new LinkedHashMap<>();

        Scanner scann=new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());
        while(n-->0){

            String[] input=scann.nextLine().split("\\s+");
            String model=input[0];
            double fuelAmount=Double.parseDouble(input[1]);
            double consumption=Double.parseDouble(input[2]);

            Car car=new Car(model,fuelAmount,consumption);
cars.put(model,car);

        }

        String[] driveCommand=scann.nextLine().split("\\s+");
        while(!driveCommand[0].equals("End")){
            String carModel=driveCommand[1];
            double kilometersToDrive=Double.parseDouble(driveCommand[2]);
            Car car=cars.get(carModel);
            if(!car.drive(kilometersToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }
            driveCommand=scann.nextLine().split("\\s+");
        }

        for (Map.Entry<String,Car> a: cars.entrySet()
             ) {
            System.out.println(a.getValue().toString());
        }
    }
}
