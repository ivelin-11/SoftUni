
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n = Integer.parseInt(scann.nextLine());
        int index=0;

        Set<String> elements =new TreeSet<>();

        while(n-->0){
            String[] input = scann.nextLine().split("\\s+");
            while(index<input.length){
                elements.add(input[index]);
                index++;
            }
            index=0;
        }

        System.out.println(String.join(" ", elements));
    }
}
