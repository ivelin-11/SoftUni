package soft2017;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08ColorCoding {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int n = Integer.parseInt(scann.nextLine());

        for (int i = 0; i < n * 2; i++) {
            List<String> colors1 = Arrays.stream(scann.nextLine().split("\\s+")).collect(Collectors.toList());
            List<String> colors2 = Arrays.stream(scann.nextLine().split("\\s+")).collect(Collectors.toList());

        }
    }
}
