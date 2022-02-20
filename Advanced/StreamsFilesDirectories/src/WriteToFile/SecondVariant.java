package WriteToFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.Set;

public class SecondVariant {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scann = new Scanner(System.in);

        String pathReader = "input.txt";
        String pathWritter = "src\\WriteToFile\\output.txt";

        FileInputStream fileInputStream = new FileInputStream(pathReader);
        FileOutputStream fileOutputStream = new FileOutputStream(pathWritter);

        Set<Character> punctuations = Set.of(',', '.', '!', '?') ;



    }
}
