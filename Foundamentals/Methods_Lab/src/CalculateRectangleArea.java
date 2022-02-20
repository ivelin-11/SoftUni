import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        double width=Integer.parseInt(scann.nextLine());
        double heigth=Integer.parseInt(scann.nextLine());
        double a=getRectangleArea(width,heigth);
        System.out.printf("%.0f",a);
    }

    private static double getRectangleArea(double width, double heigth) {

        return width*heigth;
    }
}
