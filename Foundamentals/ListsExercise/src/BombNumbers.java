

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<Integer> numbersList= Arrays.stream(scann.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
String[] bomb=scann.nextLine().split(" ");

int bombPower=Integer.parseInt(bomb[1]);
int bombNumber=Integer.parseInt(bomb[0]);

while(numbersList.contains(bombNumber)){
    if(numbersList.contains(bombNumber)){


//remove left elements
for(int i=0;i<bombPower;i++){
    int index=numbersList.indexOf(bombNumber);
    if(index==0){
        break;
    }
    numbersList.remove(index-1);
}

//remove right elements
        for(int i=0;i<bombPower;i++){
            int index=numbersList.indexOf(bombNumber);
            if(index==numbersList.size()-1){
                break;
            }
            numbersList.remove(index+1);

        }

        int b=numbersList.indexOf(bombNumber);
        numbersList.remove(b);
    }
}
int sum=0;
        for (int a:numbersList) {
            sum+=a;

        }
        System.out.println(sum);
    }
}
