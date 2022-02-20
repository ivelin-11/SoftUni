import java.text.DecimalFormat;
import java.util.Scanner;

public class MAthPower {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Double x=Double.parseDouble(scann.nextLine());
        Double y=Double.parseDouble(scann.nextLine());
   double a=MathPow(x,y);
        DecimalFormat df1=new DecimalFormat("#.####");

        System.out.println(df1.format(a));
    }

    private static double MathPow(Double x, Double y) {

            double a=Math.pow(x,y);return a;
    }
}
