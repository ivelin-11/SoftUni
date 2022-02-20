package catHouse.entities.cat;

public class LonghairCat extends BaseCat{

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(9);
    }

    @Override
    public void eating() {
        int newKilograms = this.getKilograms() + 3;
        this.setKilograms(newKilograms);
    }
}
