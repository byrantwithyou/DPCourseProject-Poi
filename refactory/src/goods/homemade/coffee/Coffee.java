package goods.homemade.coffee;

import goods.homemade.HomemadeGoods;

/**
 * @author Hao Yuan
 */
public class Coffee extends HomemadeGoods {
    private String name;
    private String temperature;
    private String sweetness;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Coffee() {
        super();
    }

    public Coffee(String temperature, String sweetness, double price) {
        super();
        this.temperature = temperature;
        this.sweetness = sweetness;
        this.price = price;
    }

//    public void printOut() {
//        System.out.println(String.format("Produced a cup of %s, temperature %s, sweetness %s, price %f. "
//                , this.getName(), this.getTemperature(), this.getSweetness(), this.getPrice()));
//    }


    public void setName(String name) {
        this.name = name;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }

    public String getName() {
        return name;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getSweetness() {
        return sweetness;
    }

    public void printOut() {
        System.out.println(String.format("手制咖啡 %s | heat %s | sweetness %s | price %f "
                , this.getName(), this.getTemperature(), this.getSweetness(), this.getPrice()));
    }
}