package SumBytes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "Exercises Resources\\input.txt";

        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);

        int charReaden = bufferedReader.read();
        long sum = 0;

        while (charReaden != -1) {
            if (charReaden != 10 && charReaden != 13) {
                sum += charReaden;
            }

            charReaden = bufferedReader.read();
        }
        System.out.println(sum);

        reader.close();
        bufferedReader.close();
    }
}
