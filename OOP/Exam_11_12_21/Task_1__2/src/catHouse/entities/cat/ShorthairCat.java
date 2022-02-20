package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    //private int kilograms=7;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(7);
    }

    @Override
    public void eating() {
        int newKilograms = this.getKilograms() + 1;
        this.setKilograms(newKilograms);
    }
}
