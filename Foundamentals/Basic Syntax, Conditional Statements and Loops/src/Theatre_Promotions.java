import java.util.Scanner;
public class Theatre_Promotions {
    public static void main(String[] args) {
      Scanner scann= new Scanner(System.in);
      String day=scann.nextLine();
      int age=Integer.parseInt(scann.nextLine());
      int price = 0;
      if(age>=0&&age<=122){
         if(age>=0&&age<=18){
             if(day.equals("Weekday")){
                 price=12;
             }
             else if(day.equals("Weekend")){
                 price=15;
             }
             else if(day.equals("Holiday")){
                 price=5;
             }
         }
          else if(age>18&&age<=64){
              if(day.equals("Weekday")){
                  price=18;
              }
              else if(day.equals("Weekend")){
                  price=20;
              }
              else if(day.equals("Holiday")){
                  price=12;
              }
          }
         else if(age>64&&age<=122) {
             if (day.equals("Weekday")) {
                 price = 12;
             } else if (day.equals("Weekend")) {
                 price = 15;
             } else if (day.equals("Holiday")) {
                 price = 10;
             }
         }
          System.out.printf("%d$", price);
      }
      else{
          System.out.println("Error!");
      }

    }
}
