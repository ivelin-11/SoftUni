import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {



        Scanner scann = new Scanner(System.in);
        String[] array= scann.nextLine().split(" ");
        Random rand = new Random();
for(int i=0;i< array.length;i++){
    int random = rand.nextInt(array.length);
    String temp=array[i];
    array[i]=array[random];
    array[random]=temp;
}
       for(String a:array){
           System.out.println(a);
       }
    }
}
