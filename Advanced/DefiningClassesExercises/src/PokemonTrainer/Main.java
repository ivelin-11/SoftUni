
package PokemonTrainer;

import java.util.*;
public class Main {
    public static void main(String[] args) {
Scanner scann=new Scanner(System.in);


Map<String,Trainer > trainers=new LinkedHashMap<>();

String command= scann.nextLine();
while(!command.equals("Tournament")){

    String[] tokens=command.split("\\s+");
    String trainerName=tokens[0];
    String pokemonName=tokens[1];
    String pokemonElement=tokens[2];
    int pokemonHealth=Integer.parseInt(tokens[3]);

    Pokemon pokemon=new Pokemon(pokemonName,pokemonElement,pokemonHealth);

    trainers.putIfAbsent(trainerName,new Trainer(trainerName,new ArrayList<>()));
    trainers.get(trainerName).getPokemonList().add(pokemon);


    command= scann.nextLine();
}

command= scann.nextLine();
while(!command.equals("End")){
    if(command.equals("Fire")){
        checkPokemonElement(trainers,command);
    }
   else if(command.equals("Electricity")){
        checkPokemonElement(trainers,command);
    }
   else  if(command.equals("Water")){
        checkPokemonElement(trainers,command);
    }


   command= scann.nextLine();
}
trainers.entrySet().stream().
        sorted((e1,e2)->Integer.compare(e2.getValue().getNumberBadges(),e1.getValue().getNumberBadges()))
        .forEach(tr->{
            System.out.println(tr.getValue().toString());
        });


        System.out.println();
    }

    private static void checkPokemonElement(Map<String,Trainer> trainers,String command) {
        for (Map.Entry<String,Trainer> trainer:trainers.entrySet()) {
            List <Pokemon> pokemons=trainer.getValue().getPokemonList();
            int countPokemon=0;//count if there is pokemons with element
            for (Pokemon temp:pokemons) {
                if(temp.getElement().equals(command)){
                    countPokemon++;break;
                }
            }

            if(countPokemon!=0){
                countPokemon+=trainer.getValue().getNumberBadges();
                trainer.getValue().setNumberBadges(countPokemon);
            }
            else{
                pokemons=trainer.getValue().getPokemonList();

                    for (Pokemon temp:pokemons) {
                        int currentHealth=temp.getHealth()-10;
                        temp.setHealth(currentHealth);
                        if(temp.getHealth()<0){
                            pokemons.remove(temp);
                        }
                        if(pokemons.size()==0){
                            break;
                        }
                    }
                }


            }
        }

    }



