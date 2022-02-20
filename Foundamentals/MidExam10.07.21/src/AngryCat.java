import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AngryCat {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        List <Integer> priceRatings= Arrays.stream(scann.nextLine().
                split(", ")).map(Integer::parseInt).
                collect(Collectors.toList());

        int entryPoint=Integer.parseInt(scann.nextLine());
        String typeOfItems= scann.nextLine();

        int leftSum=0,rightSum=0;
        for(int i=entryPoint-1;i>=0;i--){
            leftSum+=priceRatings.get(i);
        }
        for(int i=entryPoint+1;i< priceRatings.size();i++){
            rightSum+= priceRatings.get(i);
        }
        if(typeOfItems.equals("cheap")){
            if(leftSum< priceRatings.get(entryPoint)&&rightSum>leftSum){
                System.out.println("Left - "+leftSum);
            }
            else if(rightSum<priceRatings.get(entryPoint)&&rightSum<leftSum){
                System.out.println("Right - "+rightSum);
            }
            else if(leftSum==rightSum){
                System.out.println("Left - "+leftSum);
            }

        }
        else  if(typeOfItems.equals("expensive")){
            if(rightSum>=priceRatings.get(entryPoint)&&rightSum>leftSum){
                System.out.println("Right - "+rightSum);
            }
            else if(leftSum>=priceRatings.get(entryPoint)&&leftSum>=rightSum){
                System.out.println("Left - "+leftSum);
            }
            else if(leftSum==rightSum){
                System.out.println("Left - "+leftSum);
            }
        }

    }
}
