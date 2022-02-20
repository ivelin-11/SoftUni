package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String animalType= scann.nextLine();

        while(!animalType.equals("Beast!")){

                String[] animalInfo = scann.nextLine().split("\\s+");

                String name = animalInfo[0];
                int age = Integer.parseInt(animalInfo[1]);
                String gender = animalInfo[2];

            try {
                switch (animalType) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat.toString());
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age,gender);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age,gender);
                        System.out.println(tomcat);
                        break;
                    default:
                        System.out.println("Invalid input!");break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());

            }
            animalType= scann.nextLine();
        }
    }
}
