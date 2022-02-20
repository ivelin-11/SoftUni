import java.util.Scanner;
public class CharsToString {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        char a=scann.nextLine().charAt(0);
        char b=scann.nextLine().charAt(0);
        char c=scann.nextLine().charAt(0);
        System.out.printf("%s%s%s",a,b,c);
    }
}
