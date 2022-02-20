import java.util.Scanner;
public class Sum_of_Odd_Numbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n=Integer.parseInt(scann.nextLine());
        int sum=0,j=1;
        for(int i=1;i<=n;i++){
            if(j%2==0){
                continue;}
            else{
                sum=sum+j;
                System.out.println(j);
                j=j+2;
            }
        }
        System.out.printf("Sum: %d", sum);
    }
}
