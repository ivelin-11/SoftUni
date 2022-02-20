package ReadFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FirstVariant {

    public static void main(String[] args) throws IOException {

        Scanner scann = new Scanner(System.in);

        String path="input.txt";
        FileInputStream fileInputStream=new FileInputStream(path);

        int readValue=fileInputStream.read();
        while(readValue!=-1){
            System.out.print(Integer.toBinaryString(readValue)+" ");
            readValue= fileInputStream.read();
        }
        fileInputStream.close();
    }
}
