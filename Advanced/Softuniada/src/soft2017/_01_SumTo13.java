package soft2017;

import java.util.Arrays;
import java.util.Scanner;


public class _01_SumTo13 {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

       int[] numbers = Arrays.stream(scann.nextLine().split("\\s+")).
               mapToInt(Integer::parseInt).toArray();

        if(Math.abs(numbers[0])+Math.abs(numbers[1])+Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(-Math.abs(numbers[0])+Math.abs(numbers[1])+Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(Math.abs(numbers[0])-Math.abs(numbers[1])+Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(Math.abs(numbers[0])+Math.abs(numbers[1])-Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(-Math.abs(numbers[0])-Math.abs(numbers[1])+Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(Math.abs(numbers[0])-Math.abs(numbers[1])-Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(-Math.abs(numbers[0])+Math.abs(numbers[1])-Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        else if(-Math.abs(numbers[0])-Math.abs(numbers[1])-Math.abs(numbers[2])==13){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}
