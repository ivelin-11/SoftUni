import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
	Scanner scann = new Scanner(System.in);
	String input= scann.nextLine();
	String[] charAray=input.split(" ");
	List <Integer> numbers= new ArrayList<>();
    for(int i=0;i< charAray.length;i++){
        numbers.add(Integer.parseInt(charAray[i]));
    }
    for(int a:numbers){
        System.out.print(a+ " ");
    }
    }
}
