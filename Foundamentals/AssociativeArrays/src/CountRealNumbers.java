import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args){
        Scanner scann = new Scanner(System.in);
        String[] input=scann.nextLine().split(" ");
        double[] numbers= Arrays.stream(input).
                mapToDouble(e->Double.parseDouble(e)).toArray();
        Map<Double,Integer> repeatedNumbers= new TreeMap<>();

for(double number:numbers){
    if(!repeatedNumbers.containsKey(number)){
        repeatedNumbers.put(number,1);
    }
    else{
        int occurences=repeatedNumbers.get(number);
        occurences++;
        repeatedNumbers.put(number,occurences);

    }
}

for(Map.Entry<Double,Integer> entry: repeatedNumbers.entrySet()){
    DecimalFormat df1=new DecimalFormat("#.######");
    System.out.printf("%s -> %d%n",df1.format(entry.getKey()),entry.getValue());
}


    }
}
