import java.util.Scanner;

public class MerrysPuppy {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Double foodMonthly=Double.parseDouble(scann.nextLine());
        Double hayMonthly=Double.parseDouble(scann.nextLine());
        Double coverMonthly=Double.parseDouble(scann.nextLine());
        Double petWeight=Double.parseDouble(scann.nextLine());
foodMonthly=foodMonthly*1000;
hayMonthly=hayMonthly*1000;
coverMonthly=coverMonthly*1000;
petWeight=petWeight*1000;
for(int i=1;i<=30;i++){
    foodMonthly-=300;
    if(i%2==0){
        hayMonthly=hayMonthly-(0.05*foodMonthly);
    }
    if(i%3==0){
coverMonthly=coverMonthly-((0.33333333333)*(petWeight));

    }
}
        foodMonthly=foodMonthly/1000;
        hayMonthly=hayMonthly/1000;
        coverMonthly=coverMonthly/1000;
        petWeight=petWeight/1000;
if(foodMonthly>0&&hayMonthly>0&&coverMonthly>0){
    System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
            foodMonthly,hayMonthly,coverMonthly);
}
else{
    System.out.println("Merry must go to the pet store!");
}
    }

}
