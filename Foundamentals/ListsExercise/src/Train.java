import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<Integer> wagons=Arrays.stream(scann.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
int maxCapacity=Integer.parseInt(scann.nextLine());
String command= scann.nextLine();
while(!command.equals("end")){
    String[] charArray=command.split(" ");
    if(charArray[0].equals("Add")){
wagons.add(Integer.valueOf(charArray[1]));

    }
    else{
int passengers=Integer.parseInt(charArray[0]);
for(int i=0;i< wagons.size();i++){
    int wagon= wagons.get(i);
    if(wagon+passengers<=maxCapacity){
       wagons.set(i,wagon+passengers) ;
       break;
    }
}
    }

    command= scann.nextLine();

}
for(int a:wagons){
    System.out.print(a+" ");
}
    }
}
