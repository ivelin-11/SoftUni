import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class GaussTrick {
    public static void main(String[] args) {
Scanner scann= new Scanner(System.in);
String[] input=scann.nextLine().split(" ");
List <Integer> numbers = new ArrayList<>();
for(int i=0;i<input.length;i++){
    numbers.add(Integer.valueOf(input[i]));
}
if(numbers.size()%2==0) {
    for (int i = 0; i < numbers.size(); i++) {
        int sum = numbers.get(i) + numbers.get(numbers.size() - 1);
        numbers.set(i, sum);
        numbers.remove(numbers.size() - 1);
    }
}
    else if(numbers.size()%2!=0){
    for (int i = 0; i < numbers.size()/2; i++) {
        int sum = numbers.get(i) + numbers.get(numbers.size() - 1);
        numbers.set(i, sum);
        numbers.remove(numbers.size() - 1);
    }
    }
        for (int a:numbers) {
            System.out.print(a+ " ");
        }

    }
}

