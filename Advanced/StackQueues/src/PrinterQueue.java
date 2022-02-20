import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        ArrayDeque<String> documents=new ArrayDeque<>();

        String command= scann.nextLine();

        while(!command.equals("print")){
            if(command.equals("cancel")){
if(documents.isEmpty()){
    System.out.println("Printer is on standby");
}
else{
    System.out.println("Canceled " + documents.poll());
}
            }
            else{
documents.offer(command);
            }
            command= scann.nextLine();
        }


       while(!documents.isEmpty()){
           System.out.println(documents.poll());
       }
    }
}
