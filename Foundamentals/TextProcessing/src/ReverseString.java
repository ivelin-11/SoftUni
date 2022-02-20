import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String input= scann.nextLine();
        StringBuilder reversed= new StringBuilder();
        while(!input.equals("end")){

            for(int i=input.length()-1;i>=0;i--){
                reversed.append(input.charAt(i));
            }
            System.out.println(input+" = "+reversed);
            reversed.setLength(0);
            input= scann.nextLine();
        }
    }
}