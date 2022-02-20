package HotelReservation;

public enum Season {
    Autumn(1),
 Spring(2),
    Winter(3),
 Summer(4);

     private int coefficient;

    Season(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
