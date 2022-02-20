package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");

        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }
public void buyProduct(Product product){
     if(this.money< product.getCost()){
         String message=String.format("%s can't afford %s",this.name,product.getName());
    throw new IllegalArgumentException(message);
     }
     this.products.add(product);
     this.money-=product.getCost();
}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder();
        if(this.products.size()==0){
            output.append(String.format("%s - Nothing bought",this.name));
        }
       else{
            output.append(this.name).append(" - ");
            for (int i=0;i< products.size();i++) {
                output.append(products.get(i).getName());
                if(i!= products.size()-1){
                    output.append(", ");
                }
            }
        }
       return output.toString().trim();
    }
}
