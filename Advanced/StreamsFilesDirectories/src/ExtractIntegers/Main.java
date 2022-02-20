package ExtractIntegers;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        String pathWriter = "src\\ExtractIntegers\\out-int.txt";

        FileInputStream fileInputStream=new FileInputStream(path);
        Scanner scann=new Scanner(fileInputStream);

        PrintStream print=new PrintStream(pathWriter);


        while(scann.hasNext()){
            if(scann.hasNextInt()){

                print.println(scann.nextInt());
            }
          scann.next();
        }
    }
}
