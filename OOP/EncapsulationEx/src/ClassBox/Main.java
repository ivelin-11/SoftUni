package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        double length=Double.parseDouble(scann.nextLine());
        double width=Double.parseDouble(scann.nextLine());
        double height=Double.parseDouble(scann.nextLine());

        Box box=new Box(length,width,height);
        System.out.printf("Surface Area - %.2f%n",box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n",box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f",box.calculateVolume());
    }
}
