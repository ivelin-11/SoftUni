import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        ArrayDeque<String> changes=new ArrayDeque<>();
        StringBuilder text=new StringBuilder();
        int n=Integer.parseInt(scann.nextLine());

int temp=0;
   while(n>0){
       String[] command=scann.nextLine().split("\\s+");

       if(command[0].equals("1")){
text.append(command[1]);
changes.push(text.toString());
       }


       else  if(command[0].equals("2")){
           int counter=Integer.parseInt(command[1]);
           text.delete(text.length()-counter,text.length());
           changes.push(text.toString());
       }

       else  if(command[0].equals("3")){
int index=Integer.parseInt(command[1]);
           System.out.println(text.charAt(index-1));
       }

       else  if(command[0].equals("4")){
if(changes.size()>1){
    changes.pop();
    text= new StringBuilder(changes.peek());
}
else{
    text= new StringBuilder();
}






       }
       n--;

   }

    }
}
