import java.util.Scanner;

public class CharacterMultiply {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int sum = 0;
        String[] input= scann.nextLine().split(" ");
        String str1 = input[0];
        String str2 = input[1];
        int minLen = Math.min(str1.length(), str2.length());
        int maxLen = Math.max(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            sum += MultiplyCharsASCII(str1.charAt(i), str2.charAt(i));
        }
        String current="";
        if (str1.length() != str2.length()) {
            if (str1.length() > str2.length()) {
                 current= str1;
            }
            else if(str1.length() < str2.length()) {
                current = str2;}
                for (int i = minLen; i < maxLen; i++)
                {
                    sum += current.charAt(i);
                }
        }
        System.out.println(sum);
    }
        public static int MultiplyCharsASCII(char a,char b){
int c=a*b;
        return c;
        }


}
