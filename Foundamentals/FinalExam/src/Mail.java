import java.util.Scanner;

public class Mail {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String email=scann.nextLine();
        String[] command=scann.nextLine().split("\\s+");

        while(!command[0].equals("Complete")){


            if(command[0].equals("Make")){

                if(command[1].equals("Upper")){
                    email=email.toUpperCase();
                    System.out.println(email);
                }
                else if(command[1].equals("Lower")){
                    email=email.toLowerCase();
                    System.out.println(email);
                }

            }

            else if(command[0].equals("GetDomain")){
                int count=Integer.parseInt(command[1]);
                String domainName=email.substring(email.length()-3,email.length());
                System.out.println(domainName);
            }

            else if(command[0].equals("GetUsername")){
                if(email.contains("@")){

                    int endIndex=email.indexOf('@');
                   String userName=email.substring(0,endIndex);
                    System.out.println(userName);
                }
                else{
                    System.out.printf("The email %s doesn't contain the @ symbol.%n",email);
                }
            }


            else if(command[0].equals("Replace")){
                char charToReplace=command[1].charAt(0);
                char newChar='-';
                email=email.replace(charToReplace,newChar);
                System.out.println(email);
            }

            else if(command[0].equals("Encrypt")){
                for(int i=0;i<email.length();i++){
                    int asciiValue=(int) email.charAt(i);
                    System.out.print(asciiValue+" ");
                }
            }


            command=scann.nextLine().split("\\s+");
        }
    }
}
