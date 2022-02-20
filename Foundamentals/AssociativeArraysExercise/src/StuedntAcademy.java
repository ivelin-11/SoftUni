import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StuedntAcademy {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        int n=Integer.parseInt(scann.nextLine());

        Map<String,Double> grades=new LinkedHashMap<>();


        while(n>0){
            String name= scann.nextLine();
            double mark=Double.parseDouble(scann.nextLine());

            grades.putIfAbsent(name,mark);
            if(grades.containsKey(name)){
                double oldMark=grades.get(name);
                mark=(mark+oldMark)/2;
                grades.put(name,mark);
            }
            n--;
        }
        grades.entrySet().stream().sorted((e1,e2)->Double.compare(e2.getValue(), e1.getValue())).filter(entry->entry.getValue()>=4.50)
                .forEach(entry->{
                    System.out.printf(entry.getKey()+" -> %.2f%n",entry.getValue());
                });

        System.out.println();
    }
}
