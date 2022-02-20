import java.lang.reflect.Array;
import java.util.Scanner;

public class PalindromeInetgers {
    public static boolean checkPalindrome(int index,String command){
        String[] input= command.split("");
        String[] reverseArray=new String[input.length];


        index=-1;
        //reverse the number
        for(int i= input.length-1;i>=0;i--){
            reverseArray[index+1]=input[i];
            index++;
        }

        //compare two numbers as arrays
        for(int i=0;i< reverseArray.length;i++){
            if(reverseArray[i].equals(input[i])){
                index=-1;//use index variable for eqaution state between numbers
            }
            else{
               return false;
            }
        }

        if(index==-1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        int index=0;
        String command= scann.nextLine();

        while(!command.equals("END")){
            boolean a=checkPalindrome(index,command);
            System.out.println(a);
            command= scann.nextLine();
        }


    }
}
