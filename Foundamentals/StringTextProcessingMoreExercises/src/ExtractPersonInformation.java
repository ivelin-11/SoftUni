import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            String text= scanner.nextLine();
            int nameStartIndex=text.indexOf('@');
            int nameEndIndex=text.indexOf('|');
            int ageStartIndex=text.indexOf('#');
            int ageEndIndex=text.indexOf('*');
            String name=text.substring(nameStartIndex+1,nameEndIndex);
            String age=text.substring(ageStartIndex+1,ageEndIndex);
            System.out.println(name+" is "+age+" years old.");
        }
    }
}
