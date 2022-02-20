import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        AtomicInteger j= new AtomicInteger();
        String[] participants=scann.nextLine().split(", ");
        String command= scann.nextLine();
        Map<String,Integer> rankedMap=new LinkedHashMap<>();
        while(!command.equals("end of race")){
String letterRegex="[A-Za-z]";
Pattern letterPattern=Pattern.compile(letterRegex);
Matcher letterMatcher= letterPattern.matcher(command);
StringBuilder name=new StringBuilder();

String numberRegex="[0-9]";
Pattern numberPattern=Pattern.compile(numberRegex);
Matcher numberMatcher= numberPattern.matcher(command);
           String number="";int distance=0;
           for(int i=0;i<command.length();i++){
               if(letterMatcher.find()){
                   name.append(letterMatcher.group());
               }
               if(numberMatcher.find()){
                   number=numberMatcher.group();
                   distance+=Integer.parseInt(number);
               }
           }

for(int i=0;i< participants.length;i++){
    if(participants[i].contentEquals(name)){
        if(rankedMap.containsKey(participants[i])){
            int oldDistance=rankedMap.get(participants[i]);
            distance+=oldDistance;
        }
        rankedMap.put(name.substring(0,name.length()),distance );

        break;
    }
}

distance=0;
name.delete(0,name.length());

            command= scann.nextLine();
        }

        rankedMap.entrySet().stream().sorted((e1,e2)->Integer.compare(e2.getValue(),e1.getValue())).forEach(
                entry->{

                    int a=0;
                    j.getAndIncrement();
                    String b="";
                    if(j.get() ==1){b="st"; System.out.println(j+b+" place: "+entry.getKey());;}
                    else if(j.get() ==2){b="nd"; System.out.println(j+b+" place: "+entry.getKey());;}
                    else if(j.get() ==3){b="rd"; System.out.println(j+b+" place: "+entry.getKey());;}


                }
        );

    }

}
