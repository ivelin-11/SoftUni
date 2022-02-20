package CountCharTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathReader = "Exercises Resources\\input.txt";
        String pathWriter = "src\\CountCharTypes\\output.txt";

        FileReader reader = new FileReader(pathReader);
        BufferedReader bufferedReader = new BufferedReader(reader);

        PrintWriter writer = new PrintWriter(pathWriter);

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuations = Set.of('!', ',', '.', '?');

        int vowelsCount = 0, consonantsCnt = 0, punctuationCnt = 0;

        int readen = bufferedReader.read();

        while (readen != -1) {
                if (vowels.contains((char) readen)) {
                    vowelsCount++;
                }
            else if (punctuations.contains((char) readen)) punctuationCnt++;
            else if(readen!=32&&readen!=10&&readen!=13) consonantsCnt++;

            readen = bufferedReader.read();
        }

        StringBuilder output = new StringBuilder();
        output.append(String.format("Vowels: %d%n", vowelsCount));
        output.append(String.format("Consonants: %d%n", consonantsCnt));
        output.append(String.format("Punctuation: %d%n", punctuationCnt));

        System.out.println(output.toString());
        writer.write(output.toString());

        reader.close();
        bufferedReader.close();
        writer.close();
    }


}
