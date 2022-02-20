import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryExtended {
    public static void main(String[] args) {
/*
Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String command;

        while (!"Home".equals(command = scanner.nextLine())) {

            if (command.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardHistory.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.pop());
                }
            } else {
                System.out.println(command);
                browserHistory.push(command);
                forwardHistory.clear();
            }
        }
 */
        Scanner scann=new Scanner(System.in);
        ArrayDeque<String> history=new ArrayDeque<>();
        ArrayDeque<String> forwardPages=new ArrayDeque<>();
        String navigation=scann.nextLine();
        String current="";

        while(!navigation.equals("Home")){
            boolean noPrevUrls=false;
            boolean noNextUrls=false;

            if(navigation.equals("back")){
                if(history.isEmpty()){
                    System.out.println("no previous URLs");
                    noPrevUrls=true;
                }
                else{
                    forwardPages.offerFirst(current);
                    current=history.pop();
                }
            }

            else if(navigation.equals("forward")){
                if(forwardPages.isEmpty()){
                    System.out.println("no next URLs");
                    noNextUrls=true;
                }
                else{
                    current=forwardPages.poll();
                }
            }

            else{
                if(!current.equals("")){
                    history.push(current);
                    forwardPages.clear();
                }
                current=navigation;
            }
            if(!noPrevUrls&&!noNextUrls){
                System.out.println(current);
            }

            navigation= scann.nextLine();
        }
    }
}
