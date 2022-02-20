import java.util.*;
public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        int countStudents=Integer.parseInt(scann.nextLine());


        Map<String,List<Double>>students=new TreeMap<>();

        while(countStudents>0){
            String[] input= scann.nextLine().split("\\s+");
            String name=input[0];
            double grade=Double.parseDouble(input[1]);

            students.putIfAbsent(name,new ArrayList<>());
            List<Double> grades=students.get(name);
            grades.add(grade);

            countStudents--;
        }
        for (Map.Entry<String,List<Double>> entry:students.entrySet()) {
            String result="";
            //Alex -> 2.00 3.00 (avg: 2.50)
            List<Double> grades=entry.getValue();
            System.out.printf("%s -> ",entry.getKey());

            double average=0;
            int gradesCount=0;
            while(gradesCount<grades.size()){
                System.out.printf("%.2f ",grades.get(gradesCount));
                average+=grades.get(gradesCount);
                gradesCount++;
            }
average=average/grades.size();
            System.out.printf("(avg: %.2f)%n",average);
        }
        System.out.println();
    }
}
