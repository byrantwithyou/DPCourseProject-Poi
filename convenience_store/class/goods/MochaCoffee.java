package goods;

public class MochaCoffee extends Coffee {

    public MochaCoffee(String temperature, String sweetness, double price) {
        super(temperature, sweetness, price);
        this.setName("Mocha Coffee");
    }

    public void printOut(){
        System.out.println(String.format("Produced a cup of %s, temperature %s, sweetness %s, price %f. "
                , this.getName(), this.getTemperature(), this.getSweetness(), this.getPrice()));
    }

}
