package shoppingSpree;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        Map<String,Person> peopleInfo=new LinkedHashMap<>();
        Map<String,Product> productsInfo=new HashMap<>();

        //read people
String[] people =scann.nextLine().split(";");
        for (String element : people) {
            String[] personData=element.split("=");
            String name=personData[0];
            double money=Double.parseDouble(personData[1]);

            try{
                Person person=new Person(name,money);
                peopleInfo.put(name,person);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        //read products
String[] products=scann.nextLine().split(";");
        for (String element : products) {
            String[] productData=element.split("=");
            String name=productData[0];
            double cost=Double.parseDouble(productData[1]);
            try{
                Product product=new Product(name,cost);
                productsInfo.put(name,product);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        //shopping
String[] input= scann.nextLine().split("\\s+");
        while(!input[0].equals("END")){

            String personName=input[0];
            String productName=input[1];

            if(peopleInfo.containsKey(personName)&&
            productsInfo.containsKey(productName)){
                try{
                    Product product= productsInfo.get(productName);
                    peopleInfo.get(personName).buyProduct(product);
                    System.out.printf("%s bought %s%n",personName,productName);
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    break;
                }
            }

            input= scann.nextLine().split("\\s+");
        }

        //print shopping results

        for(Map.Entry<String,Person> personEntry:peopleInfo.entrySet()){
            System.out.println(personEntry.getValue().toString());
        }
    }
}
