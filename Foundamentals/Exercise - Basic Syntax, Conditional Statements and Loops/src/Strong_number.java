import java.util.Scanner;
public class Strong_number {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n=Integer.parseInt(scann.nextLine());
        int x=n,fact=1,sum=0;
        while(n!=0){
            int a=n%10;
            for(int i=1;i<=a;i++){
                fact=fact*i;
            }
            sum+=fact;
            n=n/10;
            fact=1;
        }
        if(sum==x){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
