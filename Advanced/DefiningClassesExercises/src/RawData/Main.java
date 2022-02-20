package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        Scanner scann = new Scanner(System.in);
        int n = Integer.parseInt(scann.nextLine());
        while (n-- > 0) {

            String[] tokens = scann.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            List<Tires> tiresList = new ArrayList<>();
            for (int i = 5; i <= 11; i += 2) {
                double tirePressure = Double.parseDouble(tokens[i]);
                int tireAge = Integer.parseInt(tokens[i + 1]);
                Tires tire = new Tires(tirePressure, tireAge);
                tiresList.add(tire);
            }
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tiresList);
            cars.add(car);
        }

        String criteria = scann.nextLine();

        if (criteria.equals("fragile")) {
            for (Car car : cars) {
                if (car.checkTire()) {
                    System.out.println(car.getModel());
                }
            }
        } else if (criteria.equals("flamable")) {
            for (Car car : cars) {
                if (car.checkEnginePower()) {
                    System.out.println(car.getModel());
                }
            }
            System.out.println();
        }
    }
}
