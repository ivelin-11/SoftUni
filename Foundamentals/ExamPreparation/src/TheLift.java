import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int numberPeople=Integer.parseInt(scann.nextLine());
        String[] inputArray=scann.nextLine().split(" ");
        int[] wagons=new int[inputArray.length];
        for(int i=0;i< wagons.length;i++ ){
            wagons[i]=Integer.parseInt(inputArray[i]);
        }
        int places=0;
        for(int i=0;i< wagons.length;i++){
            places=0;
            if(wagons[i]>=0&&wagons[i]<4){
                if(numberPeople>=4){
                    places=4-wagons[i];
                }
                else{
                    places=numberPeople;
                }
                wagons[i]=wagons[i]+places;
                numberPeople-=places;
            }
        }
        boolean stateFirst=false,stateSecond=false,stateThird=false;
        for(int i=0;i< wagons.length;i++){
           if(numberPeople==0){
               if(wagons[i]<=4){
                   if(wagons[i]<4){
                       stateFirst=true;
                       stateSecond=false;
                   }
                   else if(wagons[i]==4){
                       stateFirst=false;
                       stateSecond=true;
                   }
               }
            }
           else if(numberPeople>0){

               stateThird=true;

           }
        }
        if(stateFirst){
            System.out.println("The lift has empty spots!");
        }
        if(stateThird){
            System.out.println("There isn't enough space! " + numberPeople + " people in a queue!");
        }
        for(int a:wagons){
            System.out.print(a+" ");
        }
    }
}
