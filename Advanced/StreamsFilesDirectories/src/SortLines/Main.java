package SortLines;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        String pathWriter = "src\\SortLines\\out-sorted-lines.txt";

        Path pathRead = Paths.get("input.txt");

        List<String> lines = Files.readAllLines(pathRead);

        Collections.sort(lines);

        FileOutputStream fileOutputStream=new FileOutputStream(pathWriter);
        PrintStream out=new PrintStream(fileOutputStream);

        for (String line:lines) {
            out.println(line);
        }

    }
}
