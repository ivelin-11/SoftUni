package ReadFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SecondVariant {
    //doesn't pass the tests in judge
    public static void main(String[] args) throws IOException {
        Scanner scann = new Scanner(System.in);

        String path = "input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner reader = new Scanner(fileInputStream);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            for (int i = 0; i < line.length(); i++) {
                System.out.print(Integer.toBinaryString(line.charAt(i))+" ");
            }
        }
        fileInputStream.close();
        reader.close();
    }
}
