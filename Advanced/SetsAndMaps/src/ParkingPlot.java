import javax.swing.plaf.basic.BasicSeparatorUI;
import java.util.*;

public class ParkingPlot {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        Set<String> cars=new LinkedHashSet<>();

        String input= scann.nextLine();
        while(!input.equals("END")) {

            String[] tokens = input.split(", ");

            String direction = tokens[0];
            String carNumber = tokens[1];

            if (direction.equals("IN")) {
                cars.add(carNumber);
            } else if (direction.equals("OUT")) {
                cars.remove(carNumber);
            }


            input = scann.nextLine();
        }

        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else{
            cars.forEach(System.out::println);
        }

    }
}
