import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        String input= scann.nextLine();
        int n=Integer.parseInt(scann.nextLine());
       String a=round(input,n);
        System.out.println(a);

    }

    private static String round(String input,int n) {
String a="";
        for(int i=0;i<n;i++){
    a=a+input;
}
        return a;
    }
}
