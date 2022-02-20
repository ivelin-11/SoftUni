import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int snowballSnow=0,snowballTime=0,snowballQuality=0;
        double snowballValue=0.0,max_4=Double.MIN_VALUE;
        int max_1=0,max_2=0,max_3=0;
        for(int i=0;i<n;i++){
             snowballSnow=Integer.parseInt(scanner.nextLine());
             snowballTime=Integer.parseInt(scanner.nextLine());
             snowballQuality=Integer.parseInt(scanner.nextLine());
            snowballValue=(double) snowballSnow/snowballTime;
            snowballValue=Math.pow(snowballValue,snowballQuality);
       if(snowballValue>max_4){
           max_4=snowballValue;
           max_3=snowballQuality;
           max_2=snowballTime;
           max_1=snowballSnow;
       }
        }
        System.out.printf("%d : %d = %.0f (%d)",max_1,max_2,max_4,max_3);
    }
}
