package soft2017;

import java.util.Scanner;

public class _03DuplicatedLetters {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        StringBuilder s = new StringBuilder(scann.nextLine());

        int steps = 0;

        int i = 0;
        while (true) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                String first = s.substring(0, i);
                String second = s.substring(i + 2, s.length());
                s=new StringBuilder();
                s.append(first) ;s.append(second);
                steps++;
                i = 0;
            } else {
                i++;
            }

            if (s.toString().trim().isEmpty() || !checkDuplicates(s)) break;
        }

        if (s.toString().trim().isEmpty()) {
            System.out.println("Empty String");
        } else {
            System.out.println(s);
        }
        System.out.println(steps + " operations");

    }

    private static boolean checkDuplicates(StringBuilder s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
