package LineNumbers;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathReader = "Exercises Resources\\inputLineNumbers.txt";
        String pathWriter = "src\\LineNumbers\\output.txt";

        FileInputStream fileInputStream=new FileInputStream(pathReader);
        Scanner scann=new Scanner(fileInputStream);
        PrintStream printStream = new PrintStream(pathWriter);

        int i=1;
        while(scann.hasNextLine()){
            printStream.printf("%d. %s%n",i++,scann.nextLine());
        }
        fileInputStream.close();
        printStream.close();
    }
}
