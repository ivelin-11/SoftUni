import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        ArrayDeque <String> history=new ArrayDeque<>();

        String navigation=scann.nextLine();
        String current="";

        while(!navigation.equals("Home")){
boolean noPrevUrls=false;

            if(navigation.equals("back")){
if(history.isEmpty()){
    System.out.println("no previous URLs");
    noPrevUrls=true;
}
else{
    current=history.pop();
}
            }

            else{
                if(!current.equals("")){
history.push(current);
                }
                current=navigation;
            }
            if(!noPrevUrls){
                System.out.println(current);
            }

            navigation= scann.nextLine();
        }
    }
}
