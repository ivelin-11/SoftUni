import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        String values = sc.nextLine();

        String[] items = values.split(" ");

        int[] arr = new int[items.length];

        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(items[i]);
        for (int i = 0; i < items.length; i++)
            System.out.print(arr[i]+ " ");
    }
}
