package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        String[] input=scann.nextLine().split("\\s+");
        List<Birthable> peoplePets=new ArrayList<>();

        while(!input[0].equals("End")){
 if(input[0].equals("Citizen")){
     peoplePets.add(new Citizen(input[1],Integer.parseInt(input[2]),input[3],input[4]));
 }
 else if(input[0].equals("Pet")){
     peoplePets.add(new Pet(input[1],input[2]));

 }


            input=scann.nextLine().split("\\s+");
        }

        String searchedYear= scann.nextLine();

        boolean isFound=false;
        for(Birthable entry:peoplePets){
            if(entry.getBirthDate().endsWith(searchedYear)){
                isFound=true;
                System.out.println(entry.getBirthDate());
            }
        }


        if(!isFound){
            System.out.println("<no output>");
        }
    }
}
