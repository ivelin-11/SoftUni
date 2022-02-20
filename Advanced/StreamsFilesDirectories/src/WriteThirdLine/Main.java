package WriteThirdLine;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathReader = "input.txt";
        String pathWriter = "src\\WriteThirdLine\\out-third-line.txt";

        FileInputStream fileInputStream = new FileInputStream(pathReader);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        FileOutputStream fileOutputStream = new FileOutputStream(pathWriter);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        String line = bufferedReader.readLine();
        int lineCounter = 1;
        while (line != null) {
            if (lineCounter % 3 == 0) {
                bufferedWriter.write(line);
               bufferedWriter.newLine();
               bufferedWriter.flush();
               bufferedWriter=new BufferedWriter(outputStreamWriter);
            }
            line = bufferedReader.readLine();

            lineCounter++;
        }

        bufferedWriter.close();
    }
}
