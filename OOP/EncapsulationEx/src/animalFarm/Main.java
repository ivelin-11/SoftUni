package animalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        String name= scann.nextLine();
        int age=Integer.parseInt(scann.nextLine());

        try{
            Chicken chicken=new Chicken(name,age);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
