import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ListOfProducts {
    public static void main(String[] args) {
      Scanner scann= new Scanner(System.in);
      List <String> products = new ArrayList<>();
      int n=Integer.parseInt(scann.nextLine());
      for(int i=0;i<n;i++){
          String input= scann.nextLine();
          products.add(input);
      }
        Collections.sort(products);
      for(int i=0;i<n;i++){ System.out.println(i+1+"."+products.get(i))
     ; }
    }
}
