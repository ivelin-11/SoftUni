import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongsExecution {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n=Integer.parseInt(scann.nextLine());
        List<Songs> songsList= new ArrayList<>();

        for(int i=0;i<n;i++){
            String[] input=scann.nextLine().split("_");
          Songs song=new Songs(input[0],input[1],input[2]);
          songsList.add(song);
        }

        String wantedList= scann.nextLine();
        checkOutput(wantedList,songsList);


    }

    private static void checkOutput(String wantedList,List<Songs> songsList) {
        for(Songs song:songsList){
            if(song.getTypeList().equals(wantedList)){
                String a=song.getName();
                System.out.println(a);
            }
            else if(wantedList.equals("all")){
                System.out.println(song);
            }
        }
    }

    public static class Songs {
        private String TypeList;
        private String Name;
        private String Time;


        public Songs(String TypeList,String Name,String Time){
            this.TypeList=TypeList;
            this.Name=Name;
            this.Time=Time;
        }

        public String getTypeList() {
            return this.TypeList;
        }

        public String getName() {
            return this.Name;
        }

        @Override
        public String toString() {
            return this.Name;
        }
    }
}


