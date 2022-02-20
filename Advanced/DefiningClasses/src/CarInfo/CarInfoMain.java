package CarInfo;

import CarInfo.CarInfo;

import java.util.Scanner;

public class CarInfoMain {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());

        CarInfo car=new CarInfo();
while(n-->0){
String[] data=scann.nextLine().split("\\s+");
car.setBrand(data[0]);
car.setModel(data[1]);
car.setHorsePower(Integer.parseInt(data[2]));
    System.out.println(car.toString());
}
    }

}
