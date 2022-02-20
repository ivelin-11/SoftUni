package GetFolderSize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("Exercises Resources");

        Deque<File> queue = new ArrayDeque<>();
        queue.add(file);

        long size=0;
        while (!queue.isEmpty()) {
            File current = queue.poll();

            if ( current.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                    else{
                        size+= Files.size(Path.of(f.getPath()));
                    }
                }
            }

        }
        System.out.println("Folder size: "+size);
    }
}
