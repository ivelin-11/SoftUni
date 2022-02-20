import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String password=scann.nextLine();

        String charNumberMessage=checkCharNumbers(password);
        String LettersNumberMessage=checkLettersDigits(password);
        String minimumDigitsMessage=checkMinimumDigits(password);

        //cheing if string are empty or not for printing
        if(!charNumberMessage.equals("")){
            System.out.println(charNumberMessage);
        }
        if(!LettersNumberMessage.equals("")){
            System.out.println(LettersNumberMessage);
        }
        if(!minimumDigitsMessage.equals("")){
            System.out.println(minimumDigitsMessage);
        }
        if(charNumberMessage.equals("")&&LettersNumberMessage.equals("")
        &&minimumDigitsMessage.equals("")){
            System.out.println("Password is valid");
        }
    }

    private static String checkMinimumDigits(String password) {
        int br=0;
        for(int i=0;i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                br++;
            }
        }
        if(br<2){
            return "Password must have at least 2 digits";
        }
        return "";
    }

    private static String checkLettersDigits(String password) {
       byte checking=0;
        for(int i=0;i< password.length();i++){
            checking=1;
            if((password.charAt(i)>=97&&password.charAt(i)<=122)
                    ||(password.charAt(i)>=65&&password.charAt(i)<=90)){
               checking=0;
            }
            else if(Character.isDigit(password.charAt(i))){
                checking=0;
            }
            if(checking!=0){
return "Password must consist only of letters and digits";
            }
        }

        return "";
    }

    private static String checkCharNumbers( String password) {

        if(password.length()>=6&&password.length()<=10){
            return "";
        }
        else{
            return "Password must be between 6 and 10 characters";
        }

    }
}
