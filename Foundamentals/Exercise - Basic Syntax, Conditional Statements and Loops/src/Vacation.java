import java.util.Scanner;
public class Vacation {
    public static void main(String[] args) {
      Scanner scann= new Scanner(System.in);
 int people =Integer.parseInt(scann.nextLine());
 String group= scann.nextLine();
 String day= scann.nextLine();
 double price=0.00,discount=0.00;
if(group.equals("Students")){
   if(day.equals("Friday")){
      price=people*8.45;
    }
    else if(day.equals("Saturday")){
        price=people*9.80;
    }
    else if(day.equals("Sunday")){
        price=people*10.46;
    }
   if(people>=30){
       discount=price*0.15;
   }
}
else if(group.equals("Business")){
            if(day.equals("Friday")){
                price=people*10.90;
                if(people>=100){
                   discount=10*10.90;
                }
            }
            else if(day.equals("Saturday")){
                price=people*15.60;
                if(people>=100){
                    discount=(10*15.60);
                }
            }
            else if(day.equals("Sunday")){
                price=people*16;
                if(people>=100){
                    discount=(10*16);
                }
            }

        }
else if(group.equals("Regular")){
    if(day.equals("Friday")){
        price=people*15;
        if(people>=10&&price<=20){
            discount=(price*0.05);
        }
    }
    else if(day.equals("Saturday")){
        price=people*20;
        if(people>=10&&price<=20){
            discount=(price*0.05);
        }
    }
    else if(day.equals("Sunday")){
        price=people*22.50;
        if(people>=10&&price<=20){
            discount=(price*0.05);
        }
    }

}
double win=price-discount;
        System.out.printf("Total price: %.2f", win);
    }
}
