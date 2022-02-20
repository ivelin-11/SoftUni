import java.util.Scanner;
public class Elevator {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int numberPeople=Integer.parseInt(scanner.nextLine());
     int elevatorCapacity=Integer.parseInt(scanner.nextLine());
     int a= (int)Math.ceil(numberPeople*1.0/elevatorCapacity);

        System.out.println(a);

    }
}
