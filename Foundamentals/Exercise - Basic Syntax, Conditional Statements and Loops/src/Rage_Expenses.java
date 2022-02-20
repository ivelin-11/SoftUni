import java.util.Scanner;
public class Rage_Expenses {
    public static void main(String[] args) {
Scanner scann = new Scanner(System.in);
int lost_games=Integer.parseInt(scann.nextLine());
float headset_price=Float.parseFloat(scann.nextLine());
float mouse_price=Float.parseFloat(scann.nextLine());
float keyboard_price=Float.parseFloat(scann.nextLine());
float display_price=Float.parseFloat(scann.nextLine());
double sum=0.00;
for(int i=1;i<=lost_games;i++){
    if(i%6==0){
        sum=sum+headset_price+mouse_price+keyboard_price;
    }
    else if(i%2==0){
        sum+=headset_price;
    }
    else if(i%3==0){
        sum+=mouse_price;
    }
    if(i%12==0){
        sum+=display_price;
    }
}
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
