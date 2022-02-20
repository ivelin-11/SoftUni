import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String input = scann.nextLine();
        List<Students> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] temp = input.split("\\s+");
            String firstName = temp[0];
            String lastName = temp[1];
            int age = Integer.parseInt(temp[2]);
            String hometown = temp[3];
            if (!isAlreadyExist(firstName, lastName, age, hometown, students)) {
                Students student = new Students(firstName, lastName, age, hometown);
                students.add(student);
            }

            input = scann.nextLine();
        }
        String city = scann.nextLine();
        for (Students student : students) {
            if (student.getHometown().equals(city)) {
                System.out.println(student);
            }
        }


    }

    private static boolean isAlreadyExist(String firstName, String lastName, int age, String hometown, List<Students> students) {
        for (Students student : students) {
            if (student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName)) {
                student.setAge(age);
                student.setHometown(hometown);
                return true;
            }

        }
        return false;
    }
}

