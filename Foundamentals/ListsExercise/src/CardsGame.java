import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        List<Integer> cardDeckFirst= Arrays.stream(scann.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> cardDeckSecond= Arrays.stream(scann.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while(cardDeckFirst.size()>0&&cardDeckSecond.size()>0){
            int cardFirst= cardDeckFirst.get(0);
            int cardSecond=cardDeckSecond.get(0);
            if(cardFirst>cardSecond){
                //put first card from the first deck to its end
                cardDeckFirst.remove(0);
                cardDeckFirst.add(cardFirst);

                //remove second card form second deck and put it to end of the first
                cardDeckSecond.remove(0);
                cardDeckFirst.add(cardSecond);
            }
            else if(cardFirst<cardSecond){
                //put second card from the second deck to its end
               cardDeckSecond.remove(0);
               cardDeckSecond.add(cardSecond);

                //remove first card form first deck and put it to end of the second
                cardDeckFirst.remove(0);
                cardDeckSecond.add(cardFirst);
            }
            else if(cardFirst==cardSecond){
                cardDeckFirst.remove(0);
                cardDeckSecond.remove(0);
            }
        }
int sum=0;
        if(cardDeckFirst.isEmpty()){
            for (int i = 0; i < cardDeckSecond.size(); i++) {
                sum += cardDeckSecond.get(i);
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
        else if(cardDeckSecond.isEmpty()){
            for (int i = 0; i < cardDeckFirst.size(); i++) {
                sum += cardDeckFirst.get(i);
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }

    }
}
