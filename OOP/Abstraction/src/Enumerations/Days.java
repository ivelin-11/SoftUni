package Enumerations;

public enum Days {

    MONDAY(1),
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private int index;
    Days(int index) {
        this.index=index;
    }
    Days(){}

    public int getIndex() {
        return index;
    }
}
