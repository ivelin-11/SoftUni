import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        List<Double> numberList = new ArrayList<>();
        String[] input = scann.nextLine().split(" ");
        for(int i=0;i< input.length;i++){
            numberList.add(Double.valueOf(input[i]));
        }


        for(int i=0;i< numberList.size()-1;i++){

            if(numberList.get(i).equals(numberList.get(i+1))){
                double suma =numberList.get(i)+numberList.get(i+1);
                numberList.set(i,suma);
                numberList.remove(i+1);
                i=-1;
            }
        }
        DecimalFormat decimalFormat=new DecimalFormat("0.#");
        for(double a:numberList){
            System.out.print(decimalFormat.format(a)+ " ");
        }
    }
}
