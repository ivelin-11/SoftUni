import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner scann=new Scanner(System.in);
        int peopleCount = Integer.parseInt(scann.nextLine());
        String peopleType = scann.nextLine();
        String dayOfWeek = scann.nextLine();
        double totalPrice = 0;
        double discount = 0;
        if (peopleType.equals("Students"))
        {
            if (dayOfWeek.equals("Friday"))
            {
                totalPrice = 8.45 * peopleCount;

            }
            else  if (dayOfWeek.equals("Saturday"))
            {
                totalPrice = 9.80 * peopleCount;

            }
            else if (dayOfWeek.equals("Sunday"))
            {
                totalPrice = 10.46 * peopleCount;

            }
            if (peopleCount>=30)
            {
                discount = totalPrice * 0.15;
                totalPrice = totalPrice - discount;
            }

        }
        else if (peopleType.equals("Business"))
        {
            if (dayOfWeek.equals("Friday"))
            {
                totalPrice = 10.90 * peopleCount;
                if (peopleCount >= 100)
                {
                    totalPrice = 10.90 * (peopleCount - 10);
                }

            }
            else if (dayOfWeek.equals("Saturday"))
            {
                totalPrice = 15.60 * peopleCount;
                if (peopleCount >= 100)
                {
                    totalPrice = 15.60 * (peopleCount - 10);
                }

            }
            else if (dayOfWeek.equals("Sunday"))
            {
                totalPrice = 16 * peopleCount;
                if (peopleCount >= 100)
                {
                    totalPrice = 16 * (peopleCount - 10);
                }

            }


        }
        else if (peopleType.equals("Regular"))
        {
            if (dayOfWeek.equals("Friday"))
            {
                totalPrice = 15 * peopleCount;

            }
            else if (dayOfWeek.equals("Saturday"))
            {
                totalPrice = 20 * peopleCount;

            }
            else if (dayOfWeek.equals("Sunday"))
            {
                totalPrice = 22.50 * peopleCount;

            }
            if (peopleCount>=10&&peopleCount<=20)
            {
                discount = totalPrice * 0.05;
                totalPrice = totalPrice - discount;

            }

        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
