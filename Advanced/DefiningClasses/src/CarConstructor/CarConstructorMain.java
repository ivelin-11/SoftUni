package CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarConstructorMain {
    public static void main(String[] args) {
        List<CarConstructor> cars=new ArrayList<>();
        Scanner scann=new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());

        while(n-->0){
            CarConstructor car;
            String[] tokens=scann.nextLine().split("\\s+");
            if(tokens.length==1){
                car=new CarConstructor(tokens[0]);
            }
            else{
                car= new CarConstructor(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
            }
            cars.add(car);
        }

        for (CarConstructor a:cars) {
            System.out.println(a.toString());
        }
    }
}
