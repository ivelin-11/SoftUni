import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stack_2 = new ArrayDeque<>();

        Arrays.stream(scann.nextLine().split("\\s+"))
                .forEach(stack::push);
        int result=0;
        while (!stack.isEmpty()) {
            stack_2.push(stack.pop());
        }

        while (stack_2.size()!=1) {
         int left=Integer.parseInt(stack_2.pop());
         String operation=stack_2.pop();
         int right=Integer.parseInt(stack_2.pop());

         if(operation.equals("+")){
             result=left+right;
             stack_2.push(String.valueOf(result));
         }
           else if(operation.equals("-")){
                result=left-right;
                stack_2.push(String.valueOf(result));
            }


}

        System.out.println(stack_2.pop());
    }
}
