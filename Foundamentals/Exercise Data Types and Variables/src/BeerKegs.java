import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       int numberKegs=Integer.parseInt(scanner.nextLine());
        double maxVolume=Double.MIN_VALUE;
        String maxKeg ="";
       for ( int i=0;i<numberKegs;i++){
            String kegModel= scanner.nextLine();
            double radiusKeg=Double.parseDouble(scanner.nextLine());
            int heightKeg=Integer.parseInt(scanner.nextLine());
            double volume=Math.PI*radiusKeg*radiusKeg*heightKeg;
       if(volume>maxVolume){
       maxVolume=volume;
      maxKeg =kegModel;
}
        }
        System.out.println(maxKeg);
    }
}
