package goods;

public class AmericanCoffee extends Coffee {

    public AmericanCoffee(String temperature, String sweetness, double price) {
        super(temperature, sweetness, price);
        this.setName("American Coffee");
        System.out.println(String.format("Produced a cup of %s, temperature %s, sweetness %s, price %f. "
                , this.getName(), this.getTemperature(), this.getSweetness(), this.getPrice()));
    }

}
