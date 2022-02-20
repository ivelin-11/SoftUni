import java.util.Scanner;
public class SpecialNumbers {
    public static void main(String[] args) {
Scanner scann=new Scanner(System.in);
int sum=0;int a=1;int b=0;
int n=Integer.parseInt(scann.nextLine());
for(int i=1;i<=n;i++){
    b=i;
    while(b>0) {
         a = b % 10;
        sum += a;
        b= b / 10;
    }
    if(sum==5||sum==7||sum==11){
        System.out.println(i+" -> True");
        sum=0;
    }
    else{
        System.out.println(i+" -> False");
        sum=0;
    }
}

    }
}
