package telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scann.nextLine().split("\\s+")).
                collect(Collectors.toList());

        List<String> urls= Arrays.stream(scann.nextLine().split("\\s+")).
                collect(Collectors.toList());

        Smartphone smartphone=new Smartphone(numbers,urls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse().trim());
    }
}
