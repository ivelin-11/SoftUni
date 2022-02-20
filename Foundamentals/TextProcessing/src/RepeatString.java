import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String[] words=scann.nextLine().split(" ");
        for(int i=0;i< words.length;i++){
            for(int j=0;j<words[i].length();j++){
                System.out.print(words[i]);
            }
        }
    }
}
