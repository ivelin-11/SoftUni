import java.util.Scanner;

public class VowelsCount {
    private static int vowelsCounter(String[] word){
        int vowelsNumber=0;
        for(int i=0;i< word.length;i++){
            if(word[i].equals("A")||
                    word[i].equals("a")||
                    word[i].equals("E")||
                    word[i].equals("e")||
                    word[i].equals("I")||
                    word[i].equals("i")||
                    word[i].equals("O")||
                    word[i].equals("o")||
                    word[i].equals("U")||
                    word[i].equals("u")
            )
                vowelsNumber++;
        }

        return vowelsNumber;
    }
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String[] word=scann.nextLine().split("");
        int vowelsNumber=vowelsCounter(word);
        System.out.println(vowelsNumber);
    }
}
