package CopyBytes;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        String pathWriter = "src\\CopyBytes\\out-as-byte.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        //FileWriter fileWriter = new FileWriter(pathWriter);

        // FileOutputStream f=new FileOutputStream(pathWriter)
        //  PrintStream print=new PrintStream(f);
        PrintStream print=new PrintStream(pathWriter);

        int read = fileInputStream.read();
        while (read != -1) {
            if (read != 10 && read != 32) {
                print.printf("%d",read);
            } else {
                print.print((char)read);
            }
            read= fileInputStream.read();

        }
        print.close();
        fileInputStream.close();
    }
}
