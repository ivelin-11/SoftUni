import java.util.Scanner;
public class Centuries_To_Minutes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
   int centuries=Integer.parseInt(scanner.nextLine());
   int years=centuries*100;
   double days=years*365.2422;
   int hours=(int)(days*24);
   int minutes=hours*60;
        System.out.printf("%d centuries = %d years = %.0f days = %d hours = %d minutes",
                centuries,
                years,
                days,
                hours,
                minutes);
    }
}
