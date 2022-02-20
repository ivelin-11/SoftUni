import java.util.Scanner;
public class Padawan_equipment {
    public static void main(String[] args) {
     Scanner scann=new Scanner(System.in);
     double moneyOwn=Double.parseDouble(scann.nextLine());
     int students=Integer.parseInt(scann.nextLine());
     double ligthsaberPrice=Double.parseDouble(scann.nextLine());
     double robesPrice=Double.parseDouble(scann.nextLine());
     double beltsPrice=Double.parseDouble(scann.nextLine());
     double price=0.0;
int br=0;
double students_2=Math.ceil(students+(students*0.1));
double lightsaber_2=ligthsaberPrice*students_2;

     for(int i=1;i<=students;i++){


      if(i%6==0){
          br++;
      }
     }
     price=lightsaber_2+(students*robesPrice)+beltsPrice*(students-br);
   if(price<=moneyOwn) {
       System.out.printf("The money is enough - it would cost %.2flv.",price);
   }
   else if(price>moneyOwn){
       double a=price-moneyOwn;
       System.out.printf("George Lucas will need %.2flv more.",a);
   }

    }
}
