import java.util.Scanner;

public class AsciiSimulator {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        char beginChar=scann.nextLine().charAt(0);
        char endChar=scann.nextLine().charAt(0);
        String text= scann.nextLine();
        int sum=0;
        int beginIndex=(int) beginChar;
        int endIndex=(int) endChar;
        for(int i=0;i<text.length();i++){
            int index=(int) text.charAt(i);
            if(index>beginIndex&&index<endIndex){
                sum+=index;
            }
        }
        System.out.println(sum);
    }
}
