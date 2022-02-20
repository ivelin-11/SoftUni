package HotelReservation;

public enum Discount {
    VIP(0.2),
    SecondVisit(0.1),
    None(0.0);

    private double percentage;
    Discount(double percentage){
        this.percentage=percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
