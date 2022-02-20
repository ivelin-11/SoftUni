import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
String action= scann.nextLine();
int firstNumber=Integer.parseInt(scann.nextLine());
int secondNumber=Integer.parseInt(scann.nextLine());

  if(action.equals("add")){
      add(firstNumber,secondNumber);
  }
  else if(action.equals("multiply")){
      multiply(firstNumber,secondNumber);
  }
  else if(action.equals("subtract")){
      substract(firstNumber,secondNumber);
  }
  else if(action.equals("divide")){
     divide(firstNumber,secondNumber);
  }

    }
    public static void add(int a,int b){
        int c=a+b;
        System.out.println(c);
    }
    public static void multiply(int a,int b){
       int c=a*b;System.out.println(c);
    }
    public static void substract(int a,int b){
       int c=a-b;System.out.println(c);
    }
    public static void divide(int a,int b){
        int c=a/b;System.out.println(c);
    }


}
