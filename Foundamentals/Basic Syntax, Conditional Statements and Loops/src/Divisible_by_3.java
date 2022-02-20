import java.util.Scanner;
public class Divisible_by_3 {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        for(int i=1;i<=100;i++){
            if(i%3==0){
                System.out.println(i);
            }
        }
    }
}


