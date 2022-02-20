import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {


    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        Map<String, String> phones = new TreeMap<>();

        String[] input = scann.nextLine().split("-");

        PhoneBook phoneBook = new PhoneBook();//to get key

        while (!input[0].equals("search")) {

            String name = input[0];
            String phone = input[1];
            phones.put(name, phone);

            input = scann.nextLine().split("-");
        }

        String command = scann.nextLine();
        while (!command.equals("stop")) {

            String output = phones.containsKey(command)?
            String.format("%s -> %s", phoneBook.getKey(command,phones),phones.get(command)):
                    String.format("Contact %s does not exist.",command);

            System.out.println(output);
            command = scann.nextLine();
        }
    }

    public String getKey(String key, Map<String, String> phones) {
        if (phones.containsKey(key)) {
            return key;
        }
        return null;
    }
}
