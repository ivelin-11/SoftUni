package trafficLights;

public class TrafficLight {
    private Colors color;

    public TrafficLight(Colors color) {
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    public void changeColor(){
        switch(this.color){
            case RED :this.color=Colors.GREEN;break;
            case GREEN:this.color=Colors.YELLOW;break;
            case YELLOW:this.color=Colors.RED;break;
        }
    }

}
