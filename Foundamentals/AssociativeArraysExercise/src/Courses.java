import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
Map<String, List<String>> courses=new LinkedHashMap<>();
       int c=0;
        String[] input=scann.nextLine().split(" : ");

        while(!input[0].equals("end")){

            if(!courses.containsKey(input[0])){
                courses.put(input[0],new ArrayList<>());
            }

            courses.get(input[0]).add(input[1]);


            input=scann.nextLine().split(" : ");;
        }

      courses.entrySet().stream().
              sorted((a, b)->Integer.compare(b.getValue().size(),
                a.getValue().size())).forEach(entry->{
          System.out.println(entry.getKey()+": "+entry.getValue().size());
          List<String> students=entry.getValue();
          students.stream().sorted().forEach(student-> System.out.println("-- "+student));
      });





    }
}
