import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int firstNumber=Integer.parseInt(scanner.nextLine());
        int secondNumber=Integer.parseInt(scanner.nextLine());
        int operation=firstNumber+secondNumber;
        int thirdNumber=Integer.parseInt(scanner.nextLine());
        operation=operation/thirdNumber;
        int fourthNumber=Integer.parseInt(scanner.nextLine());
        operation=operation*fourthNumber;
        System.out.println(operation);
    }
}
