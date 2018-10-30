package goods.homemade.coffee;

public class MochaCoffee extends Coffee {

    public MochaCoffee(String temperature, String sweetness, double price) {
        super(temperature, sweetness, price);
        this.setName("Mocha Coffee");
    }

}
