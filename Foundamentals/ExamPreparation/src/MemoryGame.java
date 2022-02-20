import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List <String> numbersList= Arrays.stream(scann.nextLine().split(" ")).collect(Collectors.toList());

String input=scann.nextLine();
int counter=0;
while(!input.equals("end")){
    counter++;
    int[] tempArray=Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt)
            .toArray();
int firstIndex=tempArray[0];
int secondIndex=tempArray[1];


if(firstIndex==secondIndex||firstIndex<0||firstIndex>= numbersList.size()
||secondIndex<0||secondIndex> numbersList.size())
{ System.out.println("Invalid input! Adding additional elements to the board");
String penaltyNumber=String.format("-%da",counter);
numbersList.add(numbersList.size()/2,penaltyNumber);
continue;
}

String firstNumber= numbersList.get(firstIndex);
String secondNumber=numbersList.get(secondIndex);

if(firstNumber.equals(secondNumber)){
   numbersList.remove(firstNumber);
   numbersList.remove(secondNumber);
    System.out.printf("Congrats! You have found matching elements - %s!%n",firstNumber);
}
else{
    System.out.println("Try again!");
}
if(numbersList.size()==0){
    break;
}
    input=scann.nextLine();
}
if(numbersList.isEmpty()){
    System.out.printf("You have won in %d turns!%n",counter);
}
else{
    System.out.println("Sorry you lose :(");
    System.out.println(String.join(" ",numbersList));
}

    }
}
