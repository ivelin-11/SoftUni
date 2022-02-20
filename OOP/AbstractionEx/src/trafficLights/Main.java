package trafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        Colors[] signals= Arrays.stream(scann.nextLine().split("\\s+")).
                map(String::toUpperCase)
                .map(Colors::valueOf).toArray(Colors[]::new);

List<TrafficLight> trafficLights=new ArrayList<>();

for(Colors color:signals){
    TrafficLight trafficLight=new TrafficLight(color);
    trafficLights.add(trafficLight);
}
int n=Integer.parseInt(scann.nextLine());
        for (int i=0;i<n;i++) {//one rotation
            for(TrafficLight trafficLight:trafficLights){
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor()+" ");
            }
            System.out.println();
        }
    }
}
