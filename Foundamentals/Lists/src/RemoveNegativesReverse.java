import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesReverse {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List <Integer> numbersList= new ArrayList<>();
        String[] input = scann.nextLine().split(" ");
        for(int i=0;i<input.length;i++){
            int a=Integer.parseInt(input[i]);
            numbersList.add(a);
        }
        for(int i=0;i<numbersList.size();i++){
            if(numbersList.get(i)<0){
                numbersList.remove(i);
                i--;
            }
        }
        if(numbersList.isEmpty()){
            System.out.println("empty");
        }
        else{
            Collections.reverse(numbersList);
            for(int a:numbersList){
                System.out.print(a+" ");
            }
        }


    }
}
