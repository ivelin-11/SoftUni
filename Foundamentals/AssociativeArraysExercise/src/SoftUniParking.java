import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());
        Map<String,String> parkingSpots=new LinkedHashMap<>();

        while(n>0){
            String[] input=scann.nextLine().split("\\s+");
            if(input[0].equals("register")){
                if(!parkingSpots.containsKey(input[1])){
                   parkingSpots.put(input[1],input[2]);
                    System.out.printf("%s registered %S successfully%n",input[1],input[2]);
                }
                else{
                    System.out.printf("ERROR: already registered with plate number %s%n",input[2]);
                }


            }

            else if(input[0].equals("unregister")){
if(parkingSpots.containsKey(input[1])){
    parkingSpots.remove(input[1]);
    System.out.printf("%s unregistered successfully%n",input[1]);
}
else{
    System.out.printf("ERROR: user %s not found%n",input[1]);
}
            }
            n--;
        }

        for (Map.Entry<String,String> a:parkingSpots.entrySet()){
            System.out.println(a.getKey()+" => "+a.getValue());
        }
    }
}
