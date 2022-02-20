package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.BaseHouse;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller {

    private Repository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        BaseHouse house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        this.houses.put(name, house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        this.houses.get(houseName).buyToy(toy);
        toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        boolean isShort = false, isLong = false;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                isShort = true;
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                isLong = true;
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        if (houses.get(houseName).getClass().getSimpleName().equals("ShortHouse") && !isShort) {
            return ConstantMessages.UNSUITABLE_HOUSE;
        } else if (houses.get(houseName).getClass().getSimpleName().equals("LongHouse") && !isLong) {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }
        this.houses.get(houseName).addCat(cat);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, cat.getClass().getSimpleName(), houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        this.houses.get(houseName).getCats().forEach(Cat::eating);
        return String.format(ConstantMessages.FEEDING_CAT, this.houses.get(houseName).getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        double sumToysPrices = this.houses.get(houseName).getToys().stream().map(Toy::getPrice).mapToDouble(Double::doubleValue).sum();
        double sumCatsPrices = this.houses.get(houseName).getCats().stream().map(Cat::getPrice).mapToDouble(Double::doubleValue).sum();
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, sumCatsPrices + sumToysPrices);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, House> entry : this.houses.entrySet()) {
            output.append(entry.getValue().getStatistics());
        }
        return output.toString().trim();
    }
}
