package CarConstructor;

public class CarConstructor {
        private String brand;
        private String model;
        private int horsePower=0;

        public CarConstructor (String brand,String model,int horsePower){
            this.brand=brand;
            this.model=model;
            this.horsePower=horsePower;
        }
    public CarConstructor(String brand,int horsePower) {
        this(brand,"unknown",horsePower);
    }
    public CarConstructor(String brand,String model) {
        this(brand,model,-1);
    }
        public CarConstructor(String brand) {
            this(brand,"unknown",-1);
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public String getBrand() {
            return brand;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public String getModel() {
            return model;
        }

        @Override
        public String toString(){
            return String.format("The car is: %s %s - %d HP.",this.brand,this.model,this.horsePower);
        }

    }


