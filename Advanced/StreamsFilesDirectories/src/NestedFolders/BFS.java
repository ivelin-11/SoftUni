package NestedFolders;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BFS {
    public static void main(String[] args) {

        File root = Path.of("Files-and-Streams").toFile();

        ArrayDeque<File> queue = new ArrayDeque<>();
        List<String> folderNames = new ArrayList<>();

        int folderCounter = 1;//start from 1 because we couunt and the root folder
        queue.offer(root);

        int fileCounter = 0;
        while (!queue.isEmpty()) {

            File currentFile = queue.poll();

            if (currentFile.isDirectory()) {
                //otherwise you can check if files is null
                //in this case it is not a folder
                File[] files = currentFile.listFiles();

                folderNames.add(currentFile.getName());

                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                        folderCounter++;
                    } else {
                        fileCounter++;
                    }
                }
            } else {
                fileCounter++;
            }
        }


        folderNames.forEach(System.out::println);
        System.out.printf("%d folders", folderCounter);
    }
}
