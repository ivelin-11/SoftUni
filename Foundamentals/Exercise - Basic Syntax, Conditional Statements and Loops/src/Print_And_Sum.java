import java.util.Scanner;
public class Print_And_Sum {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        int number =Integer.parseInt(scann.nextLine());
        int n =Integer.parseInt(scann.nextLine());
    int sum=0;
        for(int i=number;i<=n;i++){
        sum+=i;
        System.out.print(i+" ");
    }

        System.out.println("\nSum: "+sum);

    }
}
