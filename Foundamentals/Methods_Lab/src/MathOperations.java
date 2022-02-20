import jdk.dynalink.Operation;

import java.util.Scanner;

public class MathOperations {
    private static int Operation(int a,int b,String o){
       if(o.equals("/")){
           return a/b;
       }
       else if(o.equals("*")){
return a*b;
       }
       else if(o.equals("+")){
return a+b;
       }
       else if(o.equals("-")){
return a-b;
       }
       return 0;
    }
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int firstNumber=Integer.parseInt(scann.nextLine());
        String operator= scann.nextLine();
        int secondNumber=Integer.parseInt(scann.nextLine());
        int result= Operation(firstNumber,secondNumber,operator);
        System.out.println(result);
    }
}
