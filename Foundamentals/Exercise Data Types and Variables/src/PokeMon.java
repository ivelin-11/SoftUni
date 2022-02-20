import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
int nPower=Integer.parseInt(scanner.nextLine());
int mDistance=Integer.parseInt(scanner.nextLine());
byte yExhaustionFactor=Byte.parseByte(scanner.nextLine());
int br=0;double n=nPower*0.50;
while(nPower>=mDistance){
    nPower=nPower-mDistance;
br++;
if(nPower==n) {
    if (yExhaustionFactor > 0) {


        nPower = (nPower / yExhaustionFactor);
    }
}

}

        System.out.println(nPower);
        System.out.println(br);
    }
}
