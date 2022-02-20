import java.util.Scanner;
public class Back_In_30_Minutes {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
    int hours=Integer.parseInt(scann.nextLine());
    int minutes=Integer.parseInt(scann.nextLine());
    minutes=minutes+30;
if(minutes>=60){
    minutes=minutes-60;
    hours++;
}
if(hours>23){
    hours=hours-24;
}
        System.out.printf("%d:%02d",hours,minutes);
    }

}
