import java.util.*;


public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        Set <String> guests=new TreeSet<>();

        String input= scann.nextLine();
        while(!input.equals("PARTY")){
            guests.add(input);
            input= scann.nextLine();
        }

        while(!input.equals("END")){
            if(guests.contains(input)){
                guests.remove(input);

            }
            input= scann.nextLine();
        }
        System.out.println(guests.size());
        guests.forEach(System.out::println);
    }
}
