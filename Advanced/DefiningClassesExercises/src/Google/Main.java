package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);


        Map<String,Person> people =new HashMap<>();
        String command= scann.nextLine();
        while(!command.equals("End")){
            String[] tokens=command.split("\\s+");
            Person person=new Person();
            String name=tokens[0];
            String identificator=tokens[1];

            people.putIfAbsent(name,person);

            if(identificator.equals("company")){
                String companyName=tokens[2];
                String department=tokens[3];
                double salary=Double.parseDouble(tokens[4]);
                Company company=new Company(companyName,department,salary);
                people.get(name).setCompany(company);
            }

            else if(identificator.equals("pokemon")){
                String pokemonName=tokens[2];
                String pokemonType=tokens[3];
                Pokemon pokemon=new Pokemon(pokemonName,pokemonType);
                people.get(name).getPokemon().add(pokemon);
            }

            else if(identificator.equals("parents")){
                String parentName=tokens[2];
                String parentAge=tokens[3];
                Parents parent=new Parents(parentName,parentAge);
                people.get(name).getParents().add(parent);
            }
            else if(identificator.equals("children")){
                String childName=tokens[2];
                String childAge=tokens[3];
                Children child=new Children(childName,childAge);
                people.get(name).getChildren().add(child);
            }
            else if(identificator.equals("car")){
                String carModel=tokens[2];
                String carSpeed=tokens[3];

                Car car=new Car(carModel,carSpeed);
                people.get(name).setCar(car);
            }


            command= scann.nextLine();
        }
        command= scann.nextLine();

        String regex="\\[";
        System.out.println(command+people.get(command).toString().
                replaceAll("\\[","").replaceAll("\\]","").replaceAll(", ",""));;
    }
}
