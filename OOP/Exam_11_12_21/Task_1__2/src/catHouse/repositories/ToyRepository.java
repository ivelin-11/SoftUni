package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ToyRepository implements Repository {

    private List<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    //todo
    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        Toy toy = null;

        for (Toy toy1 : toys) {
            if (toy1.getClass().getSimpleName().equals(type)) {
                toy = toy1;
                return toy;
            }
        }
        return toy;
    }
}
