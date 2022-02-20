import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        ArrayDeque<String> people=new ArrayDeque<>();

        Arrays.stream(scann.nextLine().split("\\s+"))
                .forEach(people::offer);
        int n=Integer.parseInt(scann.nextLine());

        while(people.size()>1){
            for(int i=1;i<n;i++){
                people.offer(people.poll());
            }
            System.out.println("Removed "+people.poll());
        }
        System.out.println("Last is "+people.poll());
    }
}
