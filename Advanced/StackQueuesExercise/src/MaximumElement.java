import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        ArrayDeque<Integer> numbers=new ArrayDeque<>();
        ArrayDeque<Integer> trafficStack=new ArrayDeque<>();
        int n=Integer.parseInt(scann.nextLine());
        while(n>0){
            String[] command=scann.nextLine().split("\\s+");
            if(command[0].equals("1")){
                numbers.push(Integer.valueOf(command[1]));
            }

            else if(command[0].equals("2")){
numbers.pop();
            }

            else if(command[0].equals("3")){
                int max=Integer.MIN_VALUE;
                while(!numbers.isEmpty()) {
                    int a=numbers.pop();
                    trafficStack.push(a);
                    if(max<=a){
                        max=a;
                    }
                }
                System.out.println(max);
                while(!trafficStack.isEmpty()){
                    numbers.push(trafficStack.pop());
                }
            }

            n--;
        }
    }
}
