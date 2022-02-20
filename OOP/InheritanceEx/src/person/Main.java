package person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String name=scann.nextLine();
        int age=Integer.parseInt(scann.nextLine());

        Child child=new Child(name,age);

        System.out.println(child.getName());
        System.out.println(child.getAge());


    }
}
