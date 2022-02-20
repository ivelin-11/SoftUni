package hotel;

import java.util.*;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;


    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }
///    •	Method add(Person person) - adds an entity to the roster if there is room for it
public void add(Person person){
        if(this.roster.size()<this.capacity){
            this.roster.add(person);
        }
}
///•	Method remove(String name) - removes a person by given name, if such exists, and returns boolean
public boolean remove(String name){
        for(var a:roster){
            if(a.getName().equals(name)){
roster.remove(a);
                return true;
        }

}
        return false;
}


///•	Method getPerson(String name, String hometown) – returns the people with the given name and hometown or null if there is no such person.
public Person getPerson(String name, String hometown){
        Person person=null;
    for(var a:roster){
        if(a.getName().equals(name)&&a.getHometown().equals(hometown)){
            person=a;
            return person;
        }

    }

    return null;
}


///•	Getter getCount() – returns the number of people.
    public  int getCount() {
    return this.roster.size();
    }

///•	getStatistics() – returns a String in the following format:

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The people in the hotel %s are:", this.name));
output.append("\n");


        for (var a:roster) {

                output.append(a.toString()).append("\n");

            }

    return output.toString().trim();
    }

///    o	"The people in the hotel {name} are:
///    {Person1}
///    {Person2}
///(…)"

}
