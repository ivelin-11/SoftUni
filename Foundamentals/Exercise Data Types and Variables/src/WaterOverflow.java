import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int n=Integer.parseInt(scanner.nextLine());
int sum=0, s=0,i=0,tank=255;
        int liters=0;
while(i<=n-1) {
    liters = Integer.parseInt(scanner.nextLine());
    i++;
    sum += liters;
    if (sum > tank) {
        sum-=liters;
        System.out.println("Insufficient capacity!");
    }
    else{
        s+=liters;
    }
}


        System.out.println(s);
    }
}
