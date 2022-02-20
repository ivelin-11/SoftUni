import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCocktails {
    static   int pearSourCounter=0, theHarvestCounter=0,
            appleHinnyCounter=0,highFashionCount=0;
    public static void main(String[] args) {
        Scanner scann = new Scanner((System.in));
int sumIngredients=0;

        ArrayDeque<Integer> ingredients=new ArrayDeque<>();
        Arrays.stream(scann.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).forEach(ingredients::offer);
        ArrayDeque<Integer> freshnessStack=new ArrayDeque<>();
        Arrays.stream(scann.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).forEach(freshnessStack::push);

        while(!ingredients.isEmpty()||!freshnessStack.isEmpty()){
            if(ingredients.isEmpty()|| freshnessStack.isEmpty()){
                break;
            }
            int ingredient=ingredients.poll();
            int freshness=freshnessStack.pop();
            if(ingredient==0){
                freshnessStack.push(freshness);
            }
            else{
int multiplciation=ingredient*freshness;
switch ((multiplciation)){
    case 150:pearSourCounter++;break;
    case 250:theHarvestCounter++;break;
    case 300:appleHinnyCounter++;break;
    case 400:highFashionCount++;break;
    default:ingredient+=5;ingredients.offer(ingredient);
}
            }
        }

String output=areAll()?
        "It's party time! The cocktails are ready!":
        "What a pity! You didn't manage to prepare all cocktails.";

        System.out.println(output);
        if(!ingredients.isEmpty()){
            while(!ingredients.isEmpty()){
                sumIngredients+=ingredients.poll();
            }
            System.out.println("Ingredients left: "+sumIngredients);
        }

        if(appleHinnyCounter>0){
            System.out.printf(" # Apple Hinny --> %d%n",appleHinnyCounter);
        }
        if(highFashionCount>0){
            System.out.printf(" # High Fashion --> %d%n",highFashionCount);
        }
        if(pearSourCounter>0){
            System.out.printf(" # Pear Sour --> %d%n",pearSourCounter);
        }
        if(theHarvestCounter>0){
            System.out.printf(" # The Harvest --> %d%n",theHarvestCounter);
        }
    }

    private static boolean areAll() {
        return pearSourCounter > 0 && theHarvestCounter > 0
                && appleHinnyCounter > 0 &&
                highFashionCount > 0;
    }
}
