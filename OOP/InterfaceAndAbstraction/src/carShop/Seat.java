package carShop;

public class Seat implements Car{

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    public String countryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder();


       // output.append(String.format("%s is %s " +
       //         "color and have %d horse power",model,color,horsePower))
       //         .append("\n");

        output.append(String.format(
                "This is %s produced in %s and have %d tires",model,countryProduced,TIRES));

        return output.toString();
    }
}
