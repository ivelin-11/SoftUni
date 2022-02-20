import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftuniCourse {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<String> subjectList= Arrays.stream(scann.nextLine().split(", ")).collect(Collectors.toList());

        String command= scann.nextLine();
while(!command.equals("course start")){
    String[] lessonsCommandArray=command.split(":");

    if(lessonsCommandArray[0].equals("Add")){
        if(!subjectList.contains(lessonsCommandArray[1])){
            subjectList.add(lessonsCommandArray[1]);
        }
    }


    else if(lessonsCommandArray[0].equals("Insert")){
if(!subjectList.contains(lessonsCommandArray[1])){
    int index=Integer.parseInt(lessonsCommandArray[2]);
    subjectList.add(index,lessonsCommandArray[1]);
}
    }


    else if(lessonsCommandArray[0].equals("Remove")){
if(subjectList.contains(lessonsCommandArray[1])){
    subjectList.remove(lessonsCommandArray[1]);
    String exercise=lessonsCommandArray[1]+"-Exercise";
    if(subjectList.contains(exercise)){
        subjectList.remove(exercise);
    }
}
    }


    else if(lessonsCommandArray[0].equals("Swap")){
if(subjectList.contains(lessonsCommandArray[1])&& subjectList.contains(lessonsCommandArray[2])){
    String firstLesson=lessonsCommandArray[1];
    String secondLesson=lessonsCommandArray[2];
    String firstExercise=lessonsCommandArray[1]+"-Exercise";
    String secondExercise=lessonsCommandArray[2]+"-Exercise";
    int firstTemp=0;int secoondTemp=0;

    if(subjectList.contains(firstExercise)){
        firstTemp++;
        subjectList.remove(firstExercise);
    }
    if(subjectList.contains(secondExercise)){
        secoondTemp++;
        subjectList.remove(secondExercise);
    }


    for(int i=0;i<subjectList.size();i++){
        if(subjectList.get(i).equals(firstLesson)){
            subjectList.set(i,secondLesson);
            if(secoondTemp>0){
                subjectList.add(i+1,secondExercise);
            }
        }
        else if(subjectList.get(i).equals(secondLesson)){
            subjectList.set(i,firstLesson);
            if(firstTemp>0){
                subjectList.add(i+1,firstExercise);
            }
        }
    }
}
    }


    else if(lessonsCommandArray[0].equals("Exercise")){
        String exercise=lessonsCommandArray[1]+"-Exercise";
        if((!subjectList.contains(exercise))&& subjectList.contains(lessonsCommandArray[1])){
            for(int i=0;i<subjectList.size();i++){
                if(subjectList.get(i).equals(lessonsCommandArray[1])){
                    subjectList.add(i+1,exercise);
                }
            }
        }
        else if(!subjectList.contains(lessonsCommandArray[1])){
            subjectList.add(lessonsCommandArray[1]);
            subjectList.add(exercise);
        }

    }




command= scann.nextLine();
}
int i=1;
        for (String a:subjectList) {
            System.out.println(i+"."+a);
            i++;
        }
    }
}
