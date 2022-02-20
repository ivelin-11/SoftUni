package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private  Company company;
    private List<Pokemon> pokemon=new ArrayList<>();
    private List<Parents> parents=new ArrayList<>();;
    private List<Children> children=new ArrayList<>();;
    private Car car;

    public Person(String name,Company company, List<Pokemon> pokemon, List<Parents> parents, List<Children> children, Car car) {
        this.name=name;
        this.company = company;
        this.pokemon = pokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }


    public Person() {
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        String companyOutput="1";
        if(getCompany()==null){
          companyOutput="";
        }
        else{
            companyOutput=getCompany()+"\n";
        }

        String pokemonOutput="";
        if(getPokemon()==null){
            pokemonOutput="";
        }
        else{
            pokemonOutput=getPokemon()+"";
        }

        String carOutput="";
        if(getCar()==null){
            carOutput="";
        }
        else{
            carOutput=getCar()+"\n";
        }

        String parentsOutput="";
        if(getParents()==null){
            parentsOutput="";
        }
        else{
            parentsOutput=getParents()+"";
        }

        String childOutput="";
        if(getChildren()==null){
            childOutput="";
        }
        else{
            childOutput=getChildren()+"";
        }
        return "\n"
                +"Company:\n" +companyOutput+
                "Car:\n"+ carOutput+
                "Pokemon:\n"+pokemonOutput+
                "Parents:\n"+ parentsOutput+
                "Children:\n"+childOutput;
    }


}
