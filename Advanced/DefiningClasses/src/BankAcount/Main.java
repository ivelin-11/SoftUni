package BankAcount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        Map<Integer,BankAccount> bankAccountMap=new HashMap<>();
        String command= scann.nextLine();
        while(!command.equals("End")){

            String[] tokens=command.split("\\s+");

            String output=null;
            if(tokens[0].equals("Create")){
BankAccount account=new BankAccount();
bankAccountMap.put(account.getId(),account);
output="Account ID"+ account.getId()+" created";
            }
else if(tokens[0].equals("Deposit")){
    int id=Integer.parseInt(tokens[1]);
   int amount=Integer.parseInt(tokens[2]);

if(!bankAccountMap.containsKey(id)){

    output="Account does not exist";

}
else{
    bankAccountMap.get(id).deposit(amount);
    output="Deposited " +amount+" to ID"+id;
}
            }

else if(tokens[0].equals("SetInterest")){
BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            }
else if(tokens[0].equals("GetInterest")){
                int id=Integer.parseInt(tokens[1]);
                int years=Integer.parseInt(tokens[2]);

                if(!bankAccountMap.containsKey(id)){
                    output="Account does not exist";

                }
                else{
                    double interest=bankAccountMap.get(id).getInterest(years);
                    output=String.format("%.2f",interest);
                }
            }
if(output!=null){
    System.out.println(output);
}
            command= scann.nextLine();
        }
    }
}
