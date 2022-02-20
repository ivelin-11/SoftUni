import java.util.*;
public class CountRealNumbers {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

       double[] numbers=Arrays.stream(scann.nextLine().split("\\s+")).
               mapToDouble(Double::parseDouble).toArray();
       Map<Double,Double> countNumbers=new LinkedHashMap<>();
        for (double a:numbers) {
            if(countNumbers.containsKey(a)){
              double newCount=countNumbers.get(a)+1;
                countNumbers.put(a,newCount);
            }
            else{
                countNumbers.put(a,1.0);
            }
        }

        for(Map.Entry<Double,Double> entry: countNumbers.entrySet()){
            System.out.printf("%.1f -> %.0f%n",entry.getKey(),entry.getValue());
        }
    }
}
