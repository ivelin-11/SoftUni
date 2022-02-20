import java.util.Scanner;

public class Lower_Or_Upper {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
    char a=scanner.nextLine().charAt(0);
    if(Character.isUpperCase(a)){
        System.out.println("upper-case");
    }
    else if(Character.isLowerCase(a)){
        System.out.println("lower-case");
    }
    }
}
