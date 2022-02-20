import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        String[] input= scann.nextLine().split(" ");
        List<Integer> numbersList= new ArrayList<>();
        for(int i=0;i< input.length;i++){
            numbersList.add(Integer.valueOf(input[i]));
        }
        String tempInput= scann.nextLine();
        while(!tempInput.equals("end")){
            String[] charArray=tempInput.split(" ");
            int index=Integer.parseInt(charArray[1]);
            switch(charArray[0]){

                case "Add": numbersList.add(Integer.valueOf(charArray[1]))
                        ;break;
                case "Remove":numbersList.remove(Integer.valueOf(charArray[1]));break;
                case "RemoveAt":numbersList.remove(index);break;
                case "Insert":numbersList.add(Integer.valueOf(charArray[2]),index);
            }
            tempInput= scann.nextLine();
            if(tempInput.equals("end")){
                break;
            }
        }
        for (int a:numbersList) {
            System.out.print(a+" ");
        }
    }
}
