import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MinerTask {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);


        String resource = " ", quantity = " ";

        int i = 0;
        String input = scann.nextLine();
        i++;
        resource = input;

        Map<String, String> resources = new LinkedHashMap<>();


        while (!input.equals("stop")) {

            if (i % 2 == 0) {
                input = scann.nextLine();
                resource = input;
            } else {
                input = scann.nextLine();
                quantity = input;
                if(resources.containsKey(resource)){
                    Integer i1 = Integer.parseInt(resources.get(resource));
                    i1+=Integer.parseInt(quantity);
                    resources.put(resource, i1.toString());
                }
                else{
                    resources.put(resource, quantity);
                }

            }


            i++;
        }
        resources.entrySet().forEach(e->{
            System.out.println(e.getKey()+" -> "+e.getValue());
        });
    }
}
