import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        Map<String, List<String> > syonymDictionary = new LinkedHashMap<>();

  int n=Integer.parseInt(scann.nextLine());
  for(int i=0;i<n;i++){
      String wordReal= scann.nextLine();
      String wordSynonym= scann.nextLine();
      if(!syonymDictionary.containsKey(wordReal)){
          List<String> synonymsForCurrentWord=new ArrayList<>();
          synonymsForCurrentWord.add(wordSynonym);
          syonymDictionary.put(wordReal,synonymsForCurrentWord);
      }
      else{
          List<String> synonymsForCurrentWord=syonymDictionary.get(wordReal);
          synonymsForCurrentWord.add(wordSynonym);
          syonymDictionary.put(wordReal,synonymsForCurrentWord);
      }
  }

  for(Map.Entry<String,List<String>> entry:syonymDictionary.entrySet()){
      System.out.printf("%s - %s%n",entry.getKey(),String.join(", ",entry.getValue()));

        }
    }
}
