import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        Map<String, List<Double>> plants=new HashMap<>();
        Map<String, List<Double>> sorted=new LinkedHashMap<>();
        int n=Integer.parseInt(scann.nextLine());
        String [] input;
        for(int i=0;i<n;i++){
input=scann.nextLine().split("<->");
            List<Double> data=new ArrayList<>();
            data.add(Double.parseDouble(input[1]));
            data.add(0.00);data.add(0.00);
plants.put(input[0],data);
        }

        String[]  command=scann.nextLine().split("\\s+");
        while(!command[0].equals("Exhibition")){


if(command[0].equals("Rate:")&&plants.containsKey(command[1])&&command[2].equals("-")){
    List<Double> data=new ArrayList<>();
    data=plants.get(command[1]);
    double oldRating=data.get(1);
    double newRating=Double.parseDouble(command[3]);
    double counter=data.get(2);counter++;data.set(2,counter);
    data.set(1,(newRating+oldRating));
    plants.put(command[1],data);
}

else if(command[0].equals("Update:")&&plants.containsKey(command[1])&&command[2].equals("-")){
    List<Double> data=new ArrayList<>();
    data=plants.get(command[1]);
    double newRarity=Double.parseDouble(command[3]);
    data.set(0,newRarity);
    plants.put(command[1],data);
}

else if(command[0].equals("Reset:")&&plants.containsKey(command[1])){
    List<Double> data=new ArrayList<>();
    data=plants.get(command[1]);
    data.set(1,0.00);
    plants.put(command[1],data);

}
else {
    System.out.println("error");
}


            command=scann.nextLine().split("\\s+");
        }


        System.out.println("Plants for the exhibition: ");
        //sort by one paramter in reverse(Descending) order and print it

     /*plants.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(o->o.getValue().get(0)))).

              forEach(entry->{
                  List<Double> data=new ArrayList<>();
                  data=entry.getValue();
                  System.out.printf("- " +entry.getKey()+"; Rarity: %.0f; Rating: %.2f%n",data.get(0),+data.get(1)/data.get(2));
              });*/




        //sort by one paramater in reverse order and put it to other map to sort if the first two values are equals

        plants.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(o->o.getValue().get(0)))).
                forEach(entry->{
                    List<Double> data=new ArrayList<>();
                    data=entry.getValue();
                    sorted.put(entry.getKey(), data);
                });

        sorted.entrySet().stream().sorted((p1,p2)->{
            int result=Double.compare(p2.getValue().get(0),p1.getValue().get(0));
            if(result==0){
                result=Double.compare(p2.getValue().get(1)/p2.getValue().get(2),p1.getValue().get(1)/p1.getValue().get(2));
            }
            return result;
        }).forEach(p -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n",
                p.getKey(),p.getValue().get(0),p.getValue().get(1)/p.getValue().get(2)));




    }
}
