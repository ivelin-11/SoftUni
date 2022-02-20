import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String[] fileInfo= scann.nextLine().split("[\\\\]");
        String fullFileName= fileInfo[fileInfo.length-1];
        String fileName=fullFileName.split("\\.")[0];
        String fileExtension=fullFileName.split("\\.")[1];
        System.out.println("File name: "+fileName);
        System.out.println("File extension: "+fileExtension);
    }
}
