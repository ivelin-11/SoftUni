import java.util.Scanner;

public class ReplaceRepeatingCchars {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String text = scann.nextLine();
        StringBuilder newText = new StringBuilder();
        newText.append(text.charAt(0));
      for(int i=1;i<text.length();i++){
          char current=text.charAt(i);
          if(current!=newText.charAt(newText.length()-1)){
              newText.append(current);
          }
      }
        System.out.println(newText);
    }
}
