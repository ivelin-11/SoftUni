import java.util.Scanner;
public class Multiplication_Table {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n=Integer.parseInt(scann.nextLine());
        int multiplication=0;
        for(int i=1;i<=10;i++){
multiplication=n*i;
        System.out.printf("%d X %d = %d %n",n,i,multiplication);
        multiplication=0;
    }
    }
}
