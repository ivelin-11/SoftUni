import java.util.*;
public class CitiesCountryContinent {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        int n=Integer.parseInt(scann.nextLine());
        Map<String,Map<String,List<String>>> continents=new LinkedHashMap<>();
        while(n-->0){
            String[] tokens=scann.nextLine().split("\\s+");
            String continent=tokens[0];
            String country=tokens[1];
            String city=tokens[2];

            continents.putIfAbsent(continent,new LinkedHashMap<>());
            Map<String,List<String>> countryCity=continents.get(continent);
            List<String> cities=countryCity.get(country);
            if(cities==null){
                cities=new ArrayList<>();
            }
            cities.add(city);
            countryCity.put(country,cities);

        }
        for (Map.Entry<String,Map<String,List<String>>> entry: continents.entrySet()) {
            System.out.printf("%s:%n",entry.getKey());
            Map<String,List<String>> countries=entry.getValue();
            for (Map.Entry<String,List<String>> secondEntry: countries.entrySet()) {
                List<String> cities=secondEntry.getValue();
                System.out.printf("%s -> %s%n",secondEntry.getKey(),String.join(", ",cities));
            }
        }
    }
}
