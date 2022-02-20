package AllCapitals;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathReader = "Exercises Resources\\input.txt";
        String pathWriter = "src//AllCapitals//out-capitals.txt";

        FileReader reader = new FileReader(pathReader);
        BufferedReader bufferedReader = new BufferedReader(reader);

        PrintStream printer=new PrintStream(pathWriter);

        int readen = bufferedReader.read();
        while (readen != -1) {
            if (readen >= 97 && readen <= 122) {
                readen=Character.toUpperCase(readen);
            }
            printer.print((char)readen);
            readen = bufferedReader.read();
        }

        reader.close();
        bufferedReader.close();
        printer.close();
    }
}
