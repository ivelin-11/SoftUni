import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Blacklist {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List <String> friendsList= Arrays.stream(scann.nextLine().
                split(", ")).collect(Collectors.toList());
        int counterBlackList=0,counterLost=0;
        String[] command= scann.nextLine().split(" ");
        while(!command[0].equals("Report")){


            if(command[0].equals("Blacklist")){
                if(friendsList.contains(command[1])){
                    int index= friendsList.indexOf(command[1]);
                    friendsList.set(index,"Blacklisted");
                    counterBlackList++;
                    System.out.println(command[1]+" was blacklisted.");
                }
                else{
                    System.out.printf("%s was not found.%n",command[1]);
                }
            }

            else if(command[0].equals("Error")){

                int indexError=Integer.parseInt(command[1]);
                if(!friendsList.get(indexError).equals("Blacklisted")&&!friendsList.get(indexError).equals("Lost")) {
                    if (indexError >= 0 && indexError < friendsList.size()) {
                            String name = friendsList.get(indexError);
                            friendsList.set(indexError, "Lost");
                            counterLost++;
                            System.out.println(name + " was lost due to an error.");

                    }
                }
            }


            else if(command[0].equals("Change")){
                int indexChange=Integer.parseInt(command[1]);
                if(indexChange>=0&&indexChange< friendsList.size()){
                    String previousName=friendsList.get(indexChange);
                    friendsList.set(indexChange,command[2]);
                    System.out.println(previousName+" changed his username to "+command[2]+".");
                }

            }


            command= scann.nextLine().split(" ");
        }


        System.out.println("Blacklisted names: "+counterBlackList);
        System.out.println("Lost names: " + counterLost);
        for(String output:friendsList){
            System.out.print(output + " ");
        }
    }

}
