import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String wordToRemove= scann.nextLine();
        String input= scann.nextLine();

        while(input.contains(wordToRemove)){
            input=removeOccurence(input,wordToRemove);
        }
        System.out.println(input);
    }

    private static String removeOccurence(String input, String wordToRemove) {
int start=input.indexOf(wordToRemove);
int end=wordToRemove.length()+input.indexOf(wordToRemove);
        String firstPart=input.substring(0,start);
    String secondPart=input.substring(end);


    return firstPart+secondPart;
    }
}
