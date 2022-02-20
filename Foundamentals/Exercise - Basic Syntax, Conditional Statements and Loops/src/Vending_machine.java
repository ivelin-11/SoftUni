import java.util.Scanner;
public class Vending_machine {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
String input =scann.nextLine();
double moneyPush=0.00,inputMoney=0.00;
while(!input.equals("Start")){
    moneyPush=Double.parseDouble(input);
    if(moneyPush==0.1||moneyPush==0.2||moneyPush==0.5||moneyPush==1||moneyPush==2){
        inputMoney+=moneyPush;
    }
    else{
        System.out.printf("Cannot accept %.2f\n",moneyPush);
    }
    input= scann.nextLine();
}

        input= scann.nextLine();
while(!input.equals("End")){
    if(input.equals("Nuts")||input.equals("Water")||input.equals("Crisps")||input.equals("Soda")||input.equals("Coke")){
        if(input.equals("Nuts")){
            if(inputMoney>=2.0){
                System.out.printf("Purchased %s\n",input);
                inputMoney-=2;
            }
            else{
                System.out.println("Sorry, not enough money");
            }
        }

        else if(input.equals("Water")){
            if(inputMoney>=0.7){
                System.out.printf("Purchased %s\n",input);
                inputMoney-=0.7;
            }
            else{
                System.out.println("Sorry, not enough money");
            }
        }

        else if(input.equals("Crisps")){
            if(inputMoney>=1.5){
                System.out.printf("Purchased %s\n",input);
                inputMoney-=1.5;
            }
            else{
                System.out.println("Sorry, not enough money");
            }
        }


        else if(input.equals("Soda")){
            if(inputMoney>=0.8){
                System.out.printf("Purchased %s\n",input);
                inputMoney-=0.8;
            }
            else{
                System.out.println("Sorry, not enough money");
            }
        }

        else if(input.equals("Coke")){
            if(inputMoney>=1.0){
                System.out.printf("Purchased %s\n",input);
                inputMoney-=1.0;
            }
            else{
                System.out.println("Sorry, not enough money");
            }
        }



    }
    else{
        System.out.println("Invalid product");
    }
    input= scann.nextLine();
}


        System.out.printf("Change: %.2f", inputMoney);
    }
}
