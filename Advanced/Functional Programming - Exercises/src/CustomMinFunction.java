import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {


        Scanner scann=new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt).
                collect(Collectors.toList());

        Function<List<Integer>,Integer> minFunc= list -> Collections.min(list);

        System.out.println(minFunc.apply(collect));
    }
}
