package cardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks: ");
        for(CardRank car:CardRank.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    car.ordinal(),car);

        }

    }

}
