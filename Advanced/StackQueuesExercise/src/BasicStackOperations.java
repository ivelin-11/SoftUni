import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        String[] input=scann.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers=new ArrayDeque<>();
        Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::valueOf).
                forEach(numbers::push);

        for (int i = 0; i <Integer.parseInt(input[1]) ; i++) {
            numbers.pop();
        }

       if(numbers.isEmpty()){
           System.out.println(0);
       }
       else if(numbers.contains(Integer.parseInt(input[2]))){
           System.out.println(true);
       }
       else{
           int min=Integer.MAX_VALUE;
           while(!numbers.isEmpty()){
               int a=numbers.pop();
               if(min>=a){
                  min=a;
               }
           }
           System.out.println(min);
       }
    }
}
