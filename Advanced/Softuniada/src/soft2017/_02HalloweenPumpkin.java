package soft2017;

import java.util.Scanner;

public class _02HalloweenPumpkin {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());

        for(int i=1;i<=n-1;i++) System.out.print(".");
        System.out.print("_/_");
        for(int i=1;i<=n-1;i++) System.out.print(".");


        System.out.println();
        System.out.print("/");
        for(int i=1;i<=n-2;i++) System.out.print(".");
        System.out.print("^,^");
        for(int i=1;i<=n-2;i++) System.out.print(".");
        System.out.print("\\");

        if(n>3){
            System.out.println();

            for(int i=1;i<=n-3;i++){
                System.out.print("|");
                for(int j=1;j<=n+n-1;j++){
                    System.out.print(".");
                }
                System.out.print("|");
                System.out.println();
            }
        }

        if(n<=3){
            System.out.println();
        }

        System.out.print("\\");
        for(int i=1;i<=n-2;i++) System.out.print(".");
        System.out.print("\\_/");
        for(int i=1;i<=n-2;i++)  System.out.print(".");
            System.out.print("/");
    }
}
