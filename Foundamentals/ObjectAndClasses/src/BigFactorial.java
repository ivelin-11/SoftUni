
import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int factorial= Integer.parseInt(scann.nextLine());
        BigInteger number = new BigInteger("1");
        for(int i=1;i<=factorial;i++){
            number=number.multiply(BigInteger.valueOf(i));
        }
        System.out.println(number);
    }
}
