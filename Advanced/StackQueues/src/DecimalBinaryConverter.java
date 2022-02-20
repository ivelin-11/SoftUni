import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalBinaryConverter {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        int number=Integer.parseInt(scann.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if(number==0){
            System.out.println(number);
        }
       else{
           while(number!=0){
               stack.push(number%2);
               number/=2;
           }
           while(!stack.isEmpty()){
               System.out.print(stack.pop());
           }
        }
    }
}
