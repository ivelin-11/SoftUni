import java.util.Scanner;
public class Train {
    public static void main(String[] args) {
      Scanner scann = new Scanner(System.in);
      int n=Integer.parseInt(scann.nextLine());
      int[] people=new int[n];int sum=0;
        for(int i=0;i<n;i++){
            people[i] = Integer.parseInt(scann.nextLine());
        sum+=people[i];
        }
        for(int i=0;i<n;i++){
            System.out.printf(people[i]+" ");
        }
        System.out.println("\n"+sum);
    }

}
