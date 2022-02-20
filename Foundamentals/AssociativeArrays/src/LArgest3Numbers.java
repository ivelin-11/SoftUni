import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LArgest3Numbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<Integer> numbers=Arrays.stream(scann.nextLine().split(" "))
                .map(element->Integer.parseInt(element)).sorted((left,right)->
                       right.compareTo(left)).collect(Collectors.toList());
        for(int i=0;i<= numbers.size()-1;i++){
            System.out.print(numbers.get(i)+" ");
            if(i==2){
                break;
            }
            
        }
    }
}
