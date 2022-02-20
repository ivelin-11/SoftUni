import java.util.Scanner;
public class Triangle_of_Numbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n=Integer.parseInt(scann.nextLine());
    for(int i=1;i<=n;i++){
        for(int j=0;j<=i-1;j++){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
    }
}
