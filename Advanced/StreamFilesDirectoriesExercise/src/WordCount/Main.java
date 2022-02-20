package WordCount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathChecker = "Exercises Resources\\words.txt";
        String pathReader = "Exercises Resources\\text.txt";
        String pathWriter = "src\\WordCount\\result.txt";

        FileInputStream fileInputStream = new FileInputStream(pathChecker);

        Map<String, Integer> words = getCheckedWords(fileInputStream);

        fileInputStream = new FileInputStream(pathReader);
        PrintStream printStream = new PrintStream(pathWriter);

        words = checkWords(fileInputStream, words);

        words.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
            printStream.print(String.format("%s - %d%n", e.getKey(), e.getValue()));
        });
    }

    private static Map<String, Integer> checkWords(FileInputStream f, Map<String, Integer> words) throws IOException {
        ;
        int readen = f.read();
        StringBuilder current = new StringBuilder();

        while (readen >= -1) {
            if (Character.isLetter(readen)) {
                current.append((char) readen);
            } else if (current.length() != 0) {
                for (Map.Entry<String, Integer> entry : words.entrySet()) {

                    if (current.toString().equals(entry.getKey())) {
                        words.put(entry.getKey(), entry.getValue() + 1);
                        break;
                    }
                }
                current = new StringBuilder();
            }
            if (readen == -1) break;
            readen = f.read();
        }

        return words;
    }

    private static Map<String, Integer> getCheckedWords(FileInputStream f) throws IOException {
        Map<String, Integer> words = new TreeMap<>();
        int readen = f.read();
        StringBuilder current = new StringBuilder();

        while (readen >= -1) {
            if (Character.isLetter(readen)) {
                current.append((char) readen);
            } else if (current.length() != 0) {
                words.putIfAbsent(current.toString(), 0);
                current = new StringBuilder();
            }
            if (readen == -1) break;
            readen = f.read();
        }
        return words;
    }
}
