import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        String input= scann.nextLine();
        String[] stringArray=input.split(" ");
        int[] array=new int[stringArray.length];
        int count = 0;
        int index = 0;
        for(int i=0;i< array.length;i++){
            array[i]=Integer.parseInt(stringArray[i]);
        }

        for (int i = 0; i <array.length ; i++) {
            int currentCount  =  0;
            for (int j = i; j <array.length ; j++) {
                if (array[i] == array[j]) {
                    currentCount++ ;
                    if (currentCount> count) {
                        count = currentCount ;
                        index = i ;
                    }
                } else {
                    break;
                }

            }

        }
        for (int i = 0; i < count; i++) {
            System.out.print(array[i + index ] + " ");
        }
    }
}
