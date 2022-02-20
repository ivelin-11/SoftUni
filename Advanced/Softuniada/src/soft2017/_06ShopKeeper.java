package soft2017;

import java.util.*;
import java.util.stream.Collectors;

public class _06ShopKeeper {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Map<Integer, Boolean> products = new HashMap<>();
        for (Integer product : input) {
            products.put(product, false);
        }

        List<Integer> orders = Arrays.stream(scann.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());


        int steps = 0;
        for (int i = 0; i < orders.size()-1; i++) {
            if (products.get(orders.get(i)) == null) {
                products.put(orders.get(i),true);
                if(i == 0 || products.get(orders.get(i+1)) == false){
                    System.out.println("impossible");return;
                }
                products.remove(orders.get(i-1));
                steps++;
            }
            else{
                products.put(orders.get(i),true);
            }
        }



//        for (int i = 0; i < orders.size() - 1; i++) {
//            if (!products.contains(orders.get(i))) {
//                int indexToReplace;
//                if (i == 0) {
//                    indexToReplace = products.indexOf(orders.get(i));
//                } else indexToReplace = products.indexOf(orders.get(i - 1));
//
//                if (indexToReplace == -1) {
//                    System.out.println("impossible");
//                    return;
//                }
//                products.set(indexToReplace, orders.get(i));
//                steps++;
//
//            }
//        }
        System.out.println(steps);


    }
}
