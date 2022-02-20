import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);

        String[] numbers=scann.nextLine().split("\\s+");
        String code= scann.nextLine();
        int i=0;StringBuilder resultMessage=new StringBuilder();
        int temp=0;
        while(!code.equals("find")){
        while(temp<code.length()){
            for(int j=0;j< numbers.length;j++){
                int increase=Integer.parseInt(numbers[j]);
                if(temp<code.length()){
                    int index=(int) code.charAt(temp) -increase;
                    char elementToAppend=(char) index;
                    resultMessage.append(elementToAppend);
                }
                else{
                    break;
                }


                temp++;
            }
        }
        int resourceBeginIndex= resultMessage.indexOf("&");
                int resourceEndIndex= resultMessage.lastIndexOf("&");
                int placeStartIndex=resultMessage.indexOf("<");
                        int placeEndIndex=resultMessage.indexOf(">");
            System.out.println("Found "+resultMessage.substring(resourceBeginIndex+1,resourceEndIndex)
            +" at "+resultMessage.substring(placeStartIndex+1,placeEndIndex));
            resultMessage.delete(0,resultMessage.length());
            temp=0;
            code= scann.nextLine();
        }

        System.out.println();
    }
}
