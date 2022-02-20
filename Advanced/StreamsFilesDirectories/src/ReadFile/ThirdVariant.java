package ReadFile;

import java.io.*;
import java.util.Scanner;

public class ThirdVariant {
    public static void main(String[] args) throws IOException {
        Scanner scann = new Scanner(System.in);

        String path = "input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader reader=new InputStreamReader(fileInputStream);

        BufferedReader bufferedReader = new BufferedReader(reader);


        OutputStreamWriter writer=new OutputStreamWriter(System.out);
        BufferedWriter writter = new BufferedWriter(writer);

        int readValue = bufferedReader.read();
        while (readValue != -1) {

            String word = Integer.toBinaryString(readValue);
            writer.write(word+" ");
            readValue = bufferedReader.read();
        }
        writer.close();
    }
}
