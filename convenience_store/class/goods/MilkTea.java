package goods;

import java.util.ArrayList;

public class MilkTea extends HomemadeGoods {
    private String name;
    private String temperature;
    private String sweetness;
    private double price;
    private ArrayList<String> topping = new ArrayList<String>();

    public MilkTea() {
        super();
    }

    public MilkTea(String temperature, String sweetness, double price, ArrayList<Integer> topping) {
        super();
        this.temperature = temperature;
        this.sweetness = sweetness;
        this.price = price;

        if (topping.contains(0)) {
            this.topping.add("Coconut");
        }
        if (topping.contains(1)) {
            this.topping.add("Pudding");
        }
        if (topping.contains(2)) {
            this.topping.add("Bean");
        }
    }

//    public void printOut() {
//        StringBuffer toppings = new StringBuffer("");
//        for (String temp : this.getTopping()) {
//            toppings.append(temp);
//            toppings.append(" ");
//        }
//
//        System.out.println(String.format("Produced a cup of %s, temperature %s, sweetness %s, price %f, topping: %s. "
//                , this.getName(), this.getTemperature(), this.getSweetness(), this.getPrice(), toppings.toString()));
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

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param oneTopping you can add one topping to the milktea at one time
     */
    public void setTopping(String oneTopping) {
        this.topping.add(oneTopping);
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

    public ArrayList<String> getTopping() {
        return topping;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void printOut() {
        System.out.println(String.format("手制奶茶 %s | temperature %s | sweetness %s |  price %f | topping: %s. "
                , this.getName(), this.getTemperature(), this.getSweetness(), this.getPrice(), topping.toString()));
    }
}
