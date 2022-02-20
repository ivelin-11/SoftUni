import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String command= scann.nextLine();
        int counterLooop=0;
        String resource="";int quantity=0;
        Map<String,Integer>  minerStuff=new LinkedHashMap<>();
        while(!command.equals("stop")){
            counterLooop++;

            if(counterLooop%2!=0){
                resource=command;
            }
            else if(counterLooop%2==0){
                quantity=Integer.parseInt(command);
                if(minerStuff.containsKey(resource)){
                    minerStuff.put(resource,minerStuff.get(resource)+quantity);
                }
                else{
                    minerStuff.put(resource,quantity);
                }

            }



            command= scann.nextLine();
        }

        for (Map.Entry<String,Integer> entry: minerStuff.entrySet()
             ) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
