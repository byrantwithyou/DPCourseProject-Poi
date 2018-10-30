package goods;

import java.util.ArrayList;

public class RedMilkTea extends MilkTea {
    public RedMilkTea(String temperature, String sweetness, double price, ArrayList<Integer> topping) {
        super(temperature, sweetness, price, topping);
        this.setName("Red Milk Tea");


    }
}
