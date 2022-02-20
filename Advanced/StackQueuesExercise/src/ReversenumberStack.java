import java.util.*;


public class ReversenumberStack {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        ArrayDeque<String> numbers=new ArrayDeque<>();

        Arrays.stream(scann.nextLine().split("\\s+"))
                .forEach(numbers::push);
        while(!numbers.isEmpty()){
            System.out.print(numbers.pop()+" ");
        }
    }
}
