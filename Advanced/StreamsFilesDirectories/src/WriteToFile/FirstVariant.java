package WriteToFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class FirstVariant {
    public static void main(String[] args) throws IOException {

        Scanner scann = new Scanner(System.in);

        String pathReader = "input.txt";
        String pathWritter = "src\\WriteToFile\\output.txt";

        FileInputStream fileInputStream = new FileInputStream(pathReader);
        FileOutputStream fileOutputStream = new FileOutputStream(pathWritter);

        Set<Character> punctuations = Set.of(',', '.', '!', '?') ;

        int value = fileInputStream.read();
        while (value != -1) {
            if (!punctuations.contains((char) value)) {
                fileOutputStream.write((char) value);
            }
            value = fileInputStream.read();
        }
    }
}
