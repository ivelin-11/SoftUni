import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        String inputPrice= scann.nextLine();double price=0.00;
        double priceWithoutTaxes=0.00,priceTaxes=0.00,taxes=0.00;
        while(!inputPrice.equals("special") &&!inputPrice.equals("regular")){
            price=Double.parseDouble(inputPrice);
            if(price<0){
                System.out.println("Invalid price!");
            }else{
                priceWithoutTaxes+=price;
                taxes=taxes+((20*price)/100);
            }

            inputPrice= scann.nextLine();
        }
        priceTaxes=priceWithoutTaxes+taxes;
        if(inputPrice.equals("special")){
            priceTaxes=priceTaxes-(0.1*priceTaxes);
        }
        if(priceTaxes==0){
            System.out.println("Invalid order!");
        }
        else{
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",priceTaxes);
        }
    }
}
