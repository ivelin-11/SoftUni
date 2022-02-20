import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
private static int ElementsIncreaseDecrease(int currentElement,int removedElement,int index,int sum,List <Integer> numbersList){
    for(int i=0;i< numbersList.size();i++){
        currentElement= numbersList.get(i);
        if(numbersList.get(i)<=removedElement){
            currentElement+=removedElement;
            numbersList.set(i,currentElement);
        }
        else if(numbersList.get(i)>removedElement){
            currentElement-=removedElement;
            numbersList.set(i,currentElement);
            //if is needed because on the last set index is 0 not number like we
            //input
            if(numbersList.size()==1){
                sum+=currentElement;
                index=0;
                numbersList.remove(index);

            }
            else{
                numbersList.set(i,currentElement);
            }

        }
    }
    return sum;
}

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        List <Integer> numbersList= Arrays.stream(scann.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int index=Integer.parseInt(scann.nextLine());
int removedElement=0,currentElement=0,lastElement=0,firstElement,sum=0;
int lastElementIndex=0,firstElementIndex=0;
        while(numbersList.size()>0){

            //1-st case
            if(index>=0&&index<= numbersList.size()-1){
              removedElement= numbersList.get(index);
              numbersList.remove(index);
              sum+=removedElement;
              //checjing the value if it is higher or not
             sum=ElementsIncreaseDecrease(currentElement,removedElement,index,sum,numbersList);
            }


            //2 case
            else if(index<0){
removedElement= numbersList.get(0);
sum+=removedElement;
lastElementIndex= numbersList.size()-1;
lastElement= numbersList.get(lastElementIndex);
numbersList.set(0, lastElement);
sum=ElementsIncreaseDecrease(currentElement,removedElement,index,sum,numbersList);

            }

            else if(index> numbersList.size()-1){
                removedElement= numbersList.get(numbersList.size()-1);sum+=removedElement;
                firstElement=numbersList.get(0);
                numbersList.remove(numbersList.size()-1);
                numbersList.add(firstElement);
                sum=ElementsIncreaseDecrease(currentElement,removedElement,index,sum,numbersList);

            }
            if(numbersList.size()==0){
                break;
            }
            index = Integer.parseInt(scann.nextLine());

        }
        System.out.println(sum);
    }
}
