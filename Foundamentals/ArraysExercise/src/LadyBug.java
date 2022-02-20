import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scann= new Scanner(System.in);
        int fieldSize = Integer.parseInt(scann.nextLine());
        int[] field= new int[fieldSize];

        String input= scann.nextLine();
        String[] tempArray=input.split(" ");
    int[] ladyBugIndexes=new int[tempArray.length];
    for(int i=0;i<ladyBugIndexes.length;i++){
        ladyBugIndexes[i]=Integer.parseInt(tempArray[i]);
    }

    for(int ladyBugIndex:ladyBugIndexes){
        if(ladyBugIndex>=0&&ladyBugIndex<=field.length-1){
            field[ladyBugIndex]=1;
        }

    }

    String command= scann.nextLine();
    while(!command.equals("end")){

tempArray=command.split(" ");
int index=Integer.parseInt(tempArray[0]);
String direction=tempArray[1];
int flyLength=Integer.parseInt(tempArray[2]);

if(index>=0&&index<=field.length-1&&field[index]==1){
 field[index]=0;
 if(direction.equals("right")){
    index+=flyLength;
    while(index<=field.length-1&&field[index]==1){
        index+=flyLength;
    }
    if(index<=field.length-1){
        field[index]=1;
    }

 }
 else if(direction.equals("left")){
index-=flyLength;

while(index>=0&&field[index]==1){
    index-=flyLength;
}
if(index>=0){
    field[index]=1;
}
 }
}


        command= scann.nextLine();
    }

    for(int number:field){
        System.out.print(number + " ");
    }
    }
}
