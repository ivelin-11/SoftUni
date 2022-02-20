package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private List<Toy> toys;
    private List<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {

        return this.toys.stream().map(Toy::getSoftness).mapToInt(Integer::intValue).sum();
    }

    @Override
    public void addCat(Cat cat) {
        //todo: cehck names and ifs
        if (cats.size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);

    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();


        //todo check delete new lien at te end and trim and %n
        output.append(String.format("%s %s:%n", getName(), getClass().getSimpleName()));

        if (cats.size() > 0) {
            output.append(String.format("Cats: %s%n", cats.stream().map(Cat::getName).collect(Collectors.joining(" "))));

        } else {
            output.append(String.format("Cats: none%n"));
        }
        output.append(String.format("Toys: %d Softness: %d%n", toys.size(), this.sumSoftness()));

        return output.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }


    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
