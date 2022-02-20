import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        ArrayDeque<String> people=new ArrayDeque<>();

        Arrays.stream(scann.nextLine().split("\\s+"))
                .forEach(people::offer);
        int n=Integer.parseInt(scann.nextLine());
int cycles=1;
        while(people.size()>1){
            for(int i=1;i<n;i++){
                people.offer(people.poll());
            }
            if(isPrime(cycles)) {
                System.out.println("Prime "+people.peek());
            }
            else{System.out.println("Removed "+people.poll());}
cycles++;
        }
        System.out.println("Last is "+people.poll());
    }
    private static boolean isPrime(int number){
        if(number==1){
            return false;
        }
        if(number==2){
            return true;
        }
        for (int i = 2; i < number; i++) {
            if(number%i==0){
                return false;
            }
        }
return true;
    }
    }

