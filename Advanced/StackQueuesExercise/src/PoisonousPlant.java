import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlant {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);


        ArrayDeque<Integer> indexToRemove =new ArrayDeque<>();

        int n=Integer.parseInt(scann.nextLine());

        List<Integer> plants= Arrays.stream(scann.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());



        int days=0;
        while(true){
            days++;
            int lastDeadDay=0;
            for(int i=0;i< plants.size()-1;i++){
                //from i=0 to < size-1
                // or from i=1 to < size
                if(plants.get(i+1)> plants.get(i)){
                    indexToRemove.push(i+1);
                    lastDeadDay=1;
                }
            }
            int end= indexToRemove.size();
          for(int i=0;i<end;i++){

                int index=indexToRemove.pop();
                plants.remove(index);
            }
            if(lastDeadDay==0){
                System.out.println(days - 1);
break;
            }
        }


    }


}
