import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class AnimalsZoo {
    public static void main(String[] args) {
      Scanner scann=new Scanner(System.in);
Map<String, List<String>> animals=new LinkedHashMap<>();
Map<String,Integer> sortedAnimals=new LinkedHashMap<>();
        Map<String,Integer> areas=new LinkedHashMap<>();



      String[] command= scann.nextLine().split("[\\s+-]");
   while(!command[0].equals("EndDay")){

       if(command[0].equals("Add:")){
           String animalName=command[1];
           int foodQuantity=Integer.parseInt(command[2]);
           String area=command[3];

           if(!animals.containsKey(animalName)){
               List<String> data=new ArrayList<>();
               data.add(String.valueOf(foodQuantity));
               data.add(area);
               animals.put(animalName,data);
               if(areas.containsKey(area)){
                   int oldValue=areas.get(area);
                   areas.put(area,oldValue+1);

               }
               else{
                   areas.put(area,1);
               }
           }
           else{
               List<String> data=animals.get(animalName);
               int oldQuantityFood=Integer.parseInt(data.get(0));
               foodQuantity+=oldQuantityFood;
               data.set(0,String.valueOf(foodQuantity));
               animals.put(animalName,data);
           }
       }



       else if(command[0].equals("Feed:")){
           String animalName=command[1];
           int foodFeeding=Integer.parseInt(command[2]);

           if(animals.containsKey(animalName)){
               List<String> data=new ArrayList<>();
               data= animals.get(animalName);
               int oldFoodValue=Integer.parseInt(data.get(0));
               oldFoodValue-=foodFeeding;
               if(oldFoodValue>0){
                   data.set(0,String.valueOf(oldFoodValue));
                   animals.put(animalName,data);
               }
               else{
                   String area=animals.get(animalName).get(1);
                   animals.remove(animalName);
                   int oldValue=areas.get(area);
                   areas.put(area,oldValue-1);
                   if(areas.get(area)==0){
                       areas.remove(area);
                   }
                   System.out.printf("%s was successfully fed%n",animalName);
               }
           }

       }


       command= scann.nextLine().split("[\\s+-]");
   }




        for (Map.Entry<String,List<String>> entry:animals.entrySet()) {
List<String> data=entry.getValue();
sortedAnimals.put(entry.getKey(), Integer.parseInt(data.get(0)));
        }
        System.out.println("Animals:");




       sortedAnimals
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue())).
              sorted((p1,p2)->{
int result=Integer.compare(p2.getValue(),p1.getValue());
    if(result==0){
        int a=(int)p1.getKey().charAt(0);
        int b=(int)p2.getKey().charAt(0);
        result=Integer.compare(a,b);

    }
    return result;
}).forEach(entry->{
    System.out.println(entry.getKey()+" -> "+ entry.getValue()+"g");
});



        System.out.println("Areas with hungry animals: ");
       areas.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).
                sorted((p1,p2)->{
                    int result=Integer.compare(p2.getValue(),p1.getValue());
                    if(result==0){
                        int a=(int)p1.getKey().charAt(0);
                        int b=(int)p2.getKey().charAt(0);
                        result=Integer.compare(a,b);

                    }
                    return result;
                }).forEach(entry->{
           System.out.println(entry.getKey()+": "+entry.getValue());
       });


        /*for (Map.Entry<String,Integer>entry: areas.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        System.out.println("end");*/
    }
}
