package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder output=new StringBuilder();


        for (String number:numbers) {
         if(checkNumber(number))   {
           output.append(String.format("Calling... %s%n",number));
         }
         else output.append(String.format("Invalid number!%n"));
        }
        return output.toString();
    }

    @Override
    public String browse() {
        StringBuilder output=new StringBuilder();


        for (String site:urls) {
            if(checkSite(site))   {
                output.append(String.format("Browsing: %s!%n",site));
            }
            else output.append(String.format("Invalid URL!%n"));
        }
        return output.toString();
    }
    
    private boolean checkNumber(String number){
        for(int i=0;i< number.length();i++){
            if(!(Character.isDigit(number.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    private boolean checkSite(String site){
        for(int i=0;i< site.length();i++){
            if(Character.isDigit(site.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
