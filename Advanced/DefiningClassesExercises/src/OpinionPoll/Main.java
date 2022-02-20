package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);


        int n=Integer.parseInt(scann.nextLine());
        List<Person> peopleSorted=new ArrayList<>();
        while(n-->0){
String[] tokens=scann.nextLine().split("\\s+");
String name=tokens[0];
int age=Integer.parseInt(tokens[1]);

Person person=new Person(name,age);
peopleSorted.add(person);
        }

       peopleSorted.stream()
               .filter(person -> person.getAge()>30)
               .sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }
}
