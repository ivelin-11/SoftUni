package BankAcount;

public class BankAccount {
    private static int accountCounter=1;
    private static double interestRate=0.02;

    private int id;
    private double balance;

    public BankAccount(){
        this.id=accountCounter;
        accountCounter++;
    }

    public static void setInterestRate(double interest){
interestRate=interest   ;
    }

    public void deposit(double amount){
        this.balance+=amount;
    }
    public double getInterest(int years){
        return years*interestRate*this.balance;
    }



    public int getId() {
        return id;
    }
}
