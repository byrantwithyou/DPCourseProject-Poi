package goods;

import java.util.ArrayList;

public abstract class AbstractFactory {
    public abstract Coffee getCoffee(int coffeeType, int temperature, int sweetness, double price,ArrayList<Integer> topping);

    public abstract MilkTea getTea(int teaType, int temperature, int sweetness, double price, ArrayList<Integer> topping);
}
