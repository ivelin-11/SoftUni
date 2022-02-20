import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        String name = " ", email = " ";

        int i = 0;
        String input = scann.nextLine();
        name = input;
        i++;

        Map<String, String> mails = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            if (i % 2 == 0) {
                input = scann.nextLine();
                name = input;
            } else {
                input = scann.nextLine();
                email = input;
                if (FixEmails.isValidEmail(email)) {
                    mails.put(name, email);
                }
            }
            i++;
        }
        mails.entrySet().forEach(e->{
            System.out.println(e.getKey()+" -> "+e.getValue());
        });
    }

    static boolean isValidEmail(String email) {
        return !email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com");
    }

}
