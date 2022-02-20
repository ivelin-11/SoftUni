package HotelReservation;

public class PriceCalculator {
private double pricePerDay=0;
private int days=0;
private String season;
    private String discount;
private double totalPrice;
    public PriceCalculator(double pricePerDay, int days,  String season,String discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double getTotalPrice() {
        totalPrice=getPricePerDay()*days;
        //push in the funciton to get the discount
        totalPrice=getDiscount(totalPrice);
        return totalPrice;
    }

    private double getDiscount(double totalPrice) {
        switch (discount){
            case "VIP":totalPrice-=totalPrice*Discount.VIP.getPercentage();break;
            case "SecondVisit":totalPrice-=totalPrice*Discount.SecondVisit.getPercentage();break;
            default:break;
        }
        return totalPrice;
    }

    //multiply depends on the season
    private double getPricePerDay(){
        switch (season){
            case "Autumn":pricePerDay=pricePerDay*Season.Autumn.getCoefficient();break;
            case "Spring":pricePerDay*=Season.Spring.getCoefficient();break;
            case "Winter":pricePerDay*=Season.Winter.getCoefficient();break;
            case "Summer":pricePerDay=pricePerDay*Season.Summer.getCoefficient();break;
        }
        return pricePerDay;
    }
}
