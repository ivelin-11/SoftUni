import java.util.*;

public class Companyusers {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        Map<String, List<String>> staff=new LinkedHashMap<>();
        String[] input=scann.nextLine().split(" -> ");
        while(!input[0].equals("End")){
staff.putIfAbsent(input[0],new ArrayList<>());
List<String> temp=staff.get(input[0]);
if(staff.containsKey(input[0])){
    if(!temp.contains(input[1])){
        staff.get(input[0]).add(input[1]);
    }

}

            input=scann.nextLine().split(" -> ");
        }

        staff.entrySet().stream().sorted((e1,e2)->e1.getKey().compareTo(e2.getKey())).forEach(
                entry->{
                    System.out.println(entry.getKey());
                    List<String> a=entry.getValue();
                    a.stream().forEach(e-> System.out.println("-- "+e));
                }
        );
    }
}
