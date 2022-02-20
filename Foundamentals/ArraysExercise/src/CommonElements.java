import java.util.Scanner;
public class CommonElements {
    public static void main(String[] args) {
Scanner scann= new Scanner(System.in);
String input= scann.nextLine();
String[] array1=input.split(" ");
input= scann.nextLine();
String[] array2=input.split(" ");
for(int i=0;i< array2.length;i++) {
for(int j=0;j< array1.length;j++){
    if(array2[i].equals(array1[j])){
        System.out.print(array2[i]+ " ");
    }
}
}

    }
}
