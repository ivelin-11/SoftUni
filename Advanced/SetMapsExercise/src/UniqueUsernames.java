import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n = Integer.parseInt(scann.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        while(n-->0){
            String username= scann.nextLine();
            usernames.add(username);
        }

        usernames.forEach(System.out::println);
    }
}
