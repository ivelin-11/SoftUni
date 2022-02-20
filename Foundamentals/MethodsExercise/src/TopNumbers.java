import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopNumbers {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<Integer> numbersList=new ArrayList<>();
        int n=Integer.parseInt(scann.nextLine());
        FindTopInteger(n,numbersList);
        for(int a:numbersList){
            System.out.println(a);
        }
    }

    private static void FindTopInteger(int n,List<Integer> numbersList) {
        int sum=0;int temp=-1;int oddCounter=0;int a=0;
        for(int i=1;i<=n;i++){
            a=i;
            oddCounter=0;sum=0;
            while(a>0){

                temp=a%10;
                if(temp%2!=0){
                    oddCounter++;
                }
                sum+=temp;
                a=a/10;

            }
            if(sum%8==0&&oddCounter>=1){
               numbersList.add(i);
            }
        }
    }
}
