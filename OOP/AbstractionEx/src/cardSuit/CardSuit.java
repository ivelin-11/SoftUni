package cardSuit;

public enum CardSuit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static String printValuesAndNames(){
        StringBuilder output=new StringBuilder();

        output.append("Card Suits: ").append("\n");


        for(CardSuit card:CardSuit.values()){
            output.append(String.format("Ordinal value: %d; Name value: %s%n"
                    ,card.ordinal(),card));
        }
        return output.toString().trim();
    }
}
