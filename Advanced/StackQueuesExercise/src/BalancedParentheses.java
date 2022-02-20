import java.util.*;
public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String input= scann.nextLine();
        boolean areBalanced=false;
        ArrayDeque<Character> openBrackets=new ArrayDeque<>();
        for (int i = 0; i <input.length() ; i++) {
char currentBracket=input.charAt(i);
if(currentBracket=='('||currentBracket=='{' ||  currentBracket=='['){
    openBrackets.push(currentBracket);
}
else if(currentBracket==')'||currentBracket=='}' ||  currentBracket==']'){
if(openBrackets.isEmpty()){
    areBalanced=false;
    break;
}
    char lastOpenBracket=openBrackets.pop();
if(lastOpenBracket=='('&&currentBracket==')'){
    areBalanced=true;
}
else if(lastOpenBracket=='{'&&currentBracket=='}'){
    areBalanced=true;
}
else if(lastOpenBracket=='['&&currentBracket==']'){
        areBalanced=true;
    }
else{
    areBalanced=false;
    break;
}
}
        }
        if(areBalanced){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }


    }
}
