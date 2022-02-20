import java.text.DecimalFormat;
import java.util.*;
public class AcademyGraduation {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        Map<String, String> students=new TreeMap<>();
        int n=Integer.parseInt(scann.nextLine());
        while(n-->0){
            String name= scann.nextLine();
            String[] tokens=scann.nextLine().split("\\s+");

            double average=0;
            DecimalFormat df1=new DecimalFormat("#.################" );

            for(int i=0;i<tokens.length;i++){
                average+=Double.parseDouble(tokens[i]);
            }
            double size=tokens.length;
            students.put(name,df1.format(average/size));
        }
        System.out.println();
        for (Map.Entry<String,String> entry:students.entrySet()) {
            System.out.println(entry.getKey()+" is graduated with "+entry.getValue());
        }
    }
}
