import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        String[] arrayString=input.split(" ");
        for(int i=0;i< arrayString.length/2;i++){
            String temp =arrayString[i];
            arrayString[i]=arrayString[arrayString.length-i-1];
        arrayString[arrayString.length-1-i]=temp;
        }

            System.out.print(String.join(" ",arrayString));

    }
}
