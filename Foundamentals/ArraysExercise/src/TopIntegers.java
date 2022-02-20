import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String input = scann.nextLine();
        String[] stringArray = input.split(" ");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        Byte temp=1;
        for (int i = 0; i < array.length ; i++) {

            for (int j = i+1; j < array.length ; j++) {
                if (array[i] >array[j]) {
                    temp = 1;
                }
                else{
                    temp=0;break;
                }

            }
            if (temp == 1) {
                System.out.print(array[i] + " ");
            }
            temp=1;

        }

    }
}
