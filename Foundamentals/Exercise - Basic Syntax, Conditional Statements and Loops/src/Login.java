import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
      Scanner scann = new Scanner(System.in);
int br=0;
      String username= scann.nextLine();
        String password="";
        for(int i=username.length() - 1;i>=0;i--){
            char symbol=username.charAt(i);
            password=password+symbol;
        }
        String password_2= scann.nextLine();
       while(!password_2.equals(password)){
           br++;
           if(br==4){
               System.out.printf("User %s blocked!",username);
          break;
           }
           System.out.println("Incorrect password. Try again.");
           password_2= scann.nextLine();
       }
if(br!=4) {
    System.out.printf("User %s logged in.", username);
}

    }
}
