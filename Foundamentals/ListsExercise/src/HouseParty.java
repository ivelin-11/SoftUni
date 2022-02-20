import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class HouseParty {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
       List<String> people = new ArrayList<>();
       int n=Integer.parseInt(scann.nextLine());

       for(int i=0;i<n;i++){
           String[] input=scann.nextLine().split(" ");

if(input[1].equals("is")&&input[2].equals("going!")){
   if(people.contains(input[0])){
       System.out.println(input[0]+" is already in the list!");
    }
   else{
       people.add(input[0]);
   }
}
else if(input[2].equals("not")){

        if(people.contains(input[0])){
            people.remove(input[0]);
        }
        else{
            System.out.println(input[0]+" is not in the list!");
        }
    }
}

for(String a:people){
    System.out.println(a);
}
    }
}
