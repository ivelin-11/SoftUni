import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MergingLists {
    public static void main(String[] args) {
    Scanner scann = new Scanner(System.in);
    String[] input= scann.nextLine().split(" ");
        String[] enter= scann.nextLine().split(" ");
        List<Integer> firstNumberList=new ArrayList<>();
        for(int i=0;i< input.length;i++){
            firstNumberList.add(Integer.valueOf(input[i]));
        }
        List <Integer> secondNumberList = new ArrayList<>();
        for(int i=0;i< enter.length;i++){
           secondNumberList.add(Integer.valueOf(enter[i]));
        }

        int shortCounter=0;int longCounter=0;
        List <Integer> resultList = new ArrayList<>();


        //purvi po-maluk
int n=firstNumberList.size()+secondNumberList.size();
        for(int i=0;i<n;i++){
            if(i%2==0){
                resultList.add(firstNumberList.get(0));
                firstNumberList.remove(0);
            }
            else if(i%2!=0){
               resultList.add(secondNumberList.get(0));
               secondNumberList.remove(0);
            }
if(firstNumberList.isEmpty()){
    shortCounter++;
    break;
}
            else if(secondNumberList.isEmpty()){
                longCounter++;
    break;
}

        }
        if(shortCounter>0){
            n= secondNumberList.size();
            for(int k=0;k<n;k++){
                resultList.add(secondNumberList.get(k));
            }
        }
        else if(longCounter>0){
            n= firstNumberList.size();
            for(int k=0;k<n;k++){
                resultList.add(firstNumberList.get(k));
            }
        }
        //izhod
        firstNumberList.clear();
        secondNumberList.clear();
        for(int a:resultList){
            System.out.print(a+" ");
        }

    }
}
