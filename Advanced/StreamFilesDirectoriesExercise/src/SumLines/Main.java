package SumLines;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "Exercises Resources\\input.txt";

        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();
        while (line != null) {

            int currentRowSum = 0;

            for (int i = 0; i < line.length(); i++) {
                currentRowSum += line.charAt(i);
            }

            System.out.println(currentRowSum);

            line = bufferedReader.readLine();
        }

        reader.close();
        bufferedReader.close();
    }
}
