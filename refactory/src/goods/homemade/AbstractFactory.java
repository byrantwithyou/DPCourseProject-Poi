package goods.homemade;

import java.util.ArrayList;

import goods.homemade.coffee.Coffee;
import goods.homemade.milktea.MilkTea;

public abstract class AbstractFactory {
    public abstract Coffee getCoffee(int coffeeType, int temperature, int sweetness, double price,ArrayList<Integer> topping);

    public abstract MilkTea getTea(int teaType, int temperature, int sweetness, double price, ArrayList<Integer> topping);
}
