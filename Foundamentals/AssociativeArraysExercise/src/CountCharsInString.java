import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        Map<Character,Integer> countSymbols= new LinkedHashMap<>();


        String text= scann.nextLine();
        for(int i=0;i<text.length();i++){
            char currentSymbol=text.charAt(i);

            if(currentSymbol==' '){
                continue;
            }
            else{
                if(countSymbols.containsKey(currentSymbol)){
                    countSymbols.put(currentSymbol,countSymbols.get(currentSymbol)+1);
                }
                else{
                    countSymbols.put(currentSymbol,1);
                }
            }
        }


        for (Map.Entry<Character,Integer> entry: countSymbols.entrySet()
             ) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
