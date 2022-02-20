import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        Map<String, List<String>> forceSide=new TreeMap<>();
        String line = scann.nextLine();

        while (!line.equals("Lumpawaroo")) {
            String[] command;
            String operand = "";

            if (line.contains("|")) {
                command = line.split("\\s+\\|\\s+");
                operand = "|";
            } else {
                command = line.split("\\s+->\\s+");
                operand = "->";
            }

if(operand.equals("|")){
forceSide.putIfAbsent(command[0],new ArrayList<>());
List<String> temp=forceSide.get(command[0]);
if(!temp.contains(command[1])){
    forceSide.get(command[0]).add(command[1]);
}
}

else if(operand.equals("->")){
    
}

            line= scann.nextLine();
        }



    }
}
