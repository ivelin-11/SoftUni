import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List <Integer> numbersList=Arrays.stream(scann.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
    String input= scann.nextLine();
    while(!input.equals("end")){
        String[] commandArray=input.split(" ");
        if(commandArray[0].equals("Delete")){
            int value=Integer.parseInt(commandArray[1]);
            for(int i=0;i< numbersList.size();i++){
                if(numbersList.get(i).equals(value)){
                    numbersList.remove(numbersList.get(i));
                    i=-1;
                }

            }
        }
        else if(commandArray[0].equals("Insert")){
int value=Integer.parseInt(commandArray[1]);
int index=Integer.parseInt(commandArray[2]);



                numbersList.add(index, value);

        }
       input= scann.nextLine();
    }
for(int a:numbersList){
    System.out.print(a+" ");
}
    }
}
