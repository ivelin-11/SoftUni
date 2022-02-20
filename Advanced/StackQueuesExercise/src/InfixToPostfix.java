import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        String[] input= scann.nextLine().split(" ");

boolean a=false;
        ArrayDeque<String> stack=new ArrayDeque<>();
        ArrayDeque<String> result=new ArrayDeque<>();

for(int i=0;i<input.length;i++){
    if(isNumber(input[i])){
        result.offer(input[i]);
    }
    else if(input[i].length()==1&&(input[i].charAt(0) >=97&& input[i].charAt(0) <=122)){
        result.offer(input[i]);
    }
    else if(isOperator(input[i])){
        //firs ttime check
        if(stack.isEmpty()){
            stack.push(input[i]);
        }
        else if(input[i].equals("(")){
            stack.push(input[i]);
        }
        else {
            // check the precedence between operations
            int current=getPrecedence(input[i]);
                    int last=getPrecedence(stack.peek());
                    if(current>=last){
                        result.offer(stack.pop());
                        stack.push(input[i]);
                    }

            else {
                stack.push(input[i]);
            }
        }
    }
    else if(input[i].equals(")")){
while(!stack.peek().equals("(")){
    result.offer(stack.pop());
}
stack.pop();
    }
}
while(!stack.isEmpty()){
    result.offer(stack.pop());
}
        System.out.println();
        for (String temp:result) {
            System.out.print(temp+" ");
        }
    }

private static int getPrecedence(String x) {
    switch (x) {
        case "+":
        case "-":
            return 2;

        case "*":
        case "/":
            return 1;
    }
    // return 5 for the bracket
    return 5;
}


    private static boolean isNumber(String a){
        // catch a error
        try {
            int Value = Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String a) {
        switch(a){
            case "+":return true;
            case "-":return true;
            case "*":return true;
            case "/":return true;
            case "(":return true;
        }
        return false;
    }

}
