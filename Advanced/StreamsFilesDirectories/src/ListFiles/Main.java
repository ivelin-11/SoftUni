package ListFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {


      // File input = Paths.get("Files-and-Streams\\input.txt").toFile();
      // File output = Paths.get("Files-and-Streams\\output.txt").toFile();

        File a=Paths.get("Files-and-Streams").toFile();
        File[] files = a.listFiles();
        for(File file:files){
            if(file.isFile()){
                System.out.println(file.getName() + ": ["+
                        Files.size(file.toPath())+"]");
            }
        }
    }
}
