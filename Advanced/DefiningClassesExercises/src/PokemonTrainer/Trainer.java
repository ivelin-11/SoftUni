package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberBadges=0;
    private List<Pokemon> pokemonList=new ArrayList<>();


    Trainer(String name,List<Pokemon> pokemonList){
this.name=name;
this.pokemonList=pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setNumberBadges(int numberBadges) {
        this.numberBadges = numberBadges;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public int getNumberBadges() {
        return numberBadges;
    }

    @Override
    public String toString() {
        return this.name+" "+getNumberBadges()+" "+pokemonList.size();
    }
}
