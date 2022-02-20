package cardsPower;

public class Card {
private CardSuit cardSuit;
private CardRank  cardRank;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower(){
        return cardSuit.getSuitPower()+cardRank.getRankPower();
    }
}
