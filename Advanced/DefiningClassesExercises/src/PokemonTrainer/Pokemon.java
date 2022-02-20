package PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon(String name,String element,int health){
        this.name=name;
        this.element=element;
        this.health=health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getElement() {
        return element;
    }
}
