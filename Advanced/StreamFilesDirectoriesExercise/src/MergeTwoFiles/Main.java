package MergeTwoFiles;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //it can also solve with store two files in the bufferWriter

        FileInputStream fileInputStream = new FileInputStream("Exercises Resources\\inputOne.txt");


        PrintStream fileWriter = new PrintStream("src\\MergeTwoFiles\\merging-output.txt");
        fileWriter.print(readFromFile(fileInputStream));
        fileInputStream = new FileInputStream("Exercises Resources\\inputTwo.txt");
        fileWriter.printf("%n");
        fileWriter.print(readFromFile(fileInputStream));
        fileWriter.close();

        //FileOutputStream fileOutputStream = new FileOutputStream("src\\MergeTwoFiles\\merging-output.txt");
        //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        //BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        //bufferedWriter.write(readFromFile(fileInputStream));
        //bufferedWriter.newLine();
        //fileInputStream = new FileInputStream("Exercises Resources\\inputTwo.txt");
        //bufferedWriter.write(readFromFile(fileInputStream));
        //bufferedWriter.close();

    }

    private static String readFromFile(FileInputStream f) throws IOException {
        StringBuilder output = new StringBuilder();
        int readen = f.read();
        while (readen != -1) {
            output.append((char) readen);
            readen = f.read();
        }
        return output.toString();
    }
}
