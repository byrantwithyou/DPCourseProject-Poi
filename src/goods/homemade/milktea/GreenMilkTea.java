package goods.homemade.milktea;

import java.util.ArrayList;

public class GreenMilkTea extends MilkTea {
    public GreenMilkTea(String temperature, String sweetness, double price, ArrayList<Integer> topping) {
        super(temperature, sweetness, price, topping);
        this.setName("Green Milk Tea");
    }


}
