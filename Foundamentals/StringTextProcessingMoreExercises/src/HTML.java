import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
String title= scann.nextLine();

       String  word= scann.nextLine();
        System.out.println("<h1>");
        System.out.println(title);
        System.out.println("</h1>");
        while(!word.equals("end of comments")){
            if(word.contains("content")){
                System.out.println("<article>");
                System.out.println(word);
                System.out.println("</article>");
            }
            else if(word.contains("comment")){
                System.out.println("<div>");
                System.out.println(word);
                System.out.println("</div>");
            }
            word= scann.nextLine();
        }


    }
}
