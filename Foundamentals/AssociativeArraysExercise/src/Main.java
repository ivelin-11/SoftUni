import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> courses=new HashMap<>();
        Scanner scannn=new Scanner((System.in));
        String input = scannn.nextLine();
        int a=Integer.parseInt(scannn.nextLine());
        courses.put(input,a);
         input = scannn.nextLine();
       a=Integer.parseInt(scannn.nextLine());
        courses.put(input,a);
        input = scannn.nextLine();
        a=Integer.parseInt(scannn.nextLine());
        courses.put(input,a);
        courses.entrySet().stream().sorted((e1,e2)->Integer.compare(e1.getValue(), e2.getValue())).forEach(System.out::println );
    }
}
