import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String[] input= scann.nextLine().split(" ");
        Map<String,Integer>words=new LinkedHashMap<>();
        for(String a:input){
            String smallLetterWord=a.toLowerCase();
            if(words.containsKey(smallLetterWord)){

                words.put(smallLetterWord,words.get(smallLetterWord)+1);
            }
            else{
words.put(smallLetterWord,1);
            }
        }

        List<String> temp=new ArrayList<>();
        for(Map.Entry <String,Integer> entry:words.entrySet()){
            if(entry.getValue()%2!=0){
                temp.add(entry.getKey());
            }

        }

        System.out.println(String.join(", ",temp));
    }
}
