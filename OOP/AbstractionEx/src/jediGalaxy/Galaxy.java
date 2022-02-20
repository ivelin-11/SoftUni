package jediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public void moveEvil(int rowEvil,int colEvil){
        while (rowEvil >= 0 && colEvil >= 0) {
            if (this.field.isInBounds(rowEvil, colEvil)) {
                this.field.setValue(rowEvil,colEvil,0);
            }
            rowEvil--;
            colEvil--;
        }
    }

    public long moveJedi(int rowJedi,int colJedi){
        long starsCollected = 0;
        while (rowJedi >= 0 && colJedi < this.field.getCOlLength(1)) {
            if (this.field.isInBounds(rowJedi, colJedi)) {
                starsCollected += this.field.getValue(rowJedi,colJedi);
            }

            colJedi++;
            rowJedi--;
        }
        return starsCollected;
    }
}
