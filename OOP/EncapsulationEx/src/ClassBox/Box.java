package ClassBox;

public class Box{
    private double length;
private double width;
private double height;


    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if(validationInput(length)){
            throw new IllegalArgumentException(getMessageError("Length"));
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(validationInput(width)){
            throw new IllegalArgumentException(getMessageError("Width"));
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(validationInput(height)){
            throw new IllegalArgumentException(getMessageError("Height"));
        }
        this.height = height;
    }

    public double calculateSurfaceArea(){
return (2*this.length*this.width)+(2*this.length*this.height)+(2*this.width*this.height);
    }
    public double calculateLateralSurfaceArea(){

        return (2*this.length*this.height)+(2*this.width*this.height);
    }

    public double calculateVolume(){
        return this.length*this.width*this.height;
    }
    private boolean validationInput(double argument){
        return argument <= 0;
    }

    private String getMessageError(String argument){
        return argument+ " cannot be zero or negative.";
    }


}
