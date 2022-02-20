import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        String input= scann.nextLine();

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);

            if(ch=='('){
                stack.push(i);
            }
            else if(ch==')'){
                int startIndex=stack.pop();
                System.out.println(input.substring(startIndex,i+1));
            }
        }
    }
}
