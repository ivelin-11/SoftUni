import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List <String> numbersList= Arrays.stream(scann.nextLine().split("\\|"))
                .collect(Collectors.toList());
Collections.reverse(numbersList);
        System.out.println(numbersList.toString().replace("[","")
        .replace("]","")
        .replaceAll(",","").trim()
         .replaceAll("\\s+"," ")
        );

       }

    }

