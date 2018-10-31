package goods.homemade.coffee;

import java.util.ArrayList;

import goods.homemade.milktea.MilkTea;
import goods.homemade.AbstractFactory;

public class CoffeeFactory extends AbstractFactory {
    public CoffeeFactory() {
        System.out.println("A coffee factory constructed.");
    }

    @Override
    /**
     * 通过咖啡工厂获得相应的咖啡实例
     * @param coffeeType 咖啡类型，0为抹茶咖啡，1位美式咖啡
     * @param temperature 温度类型，0为冰，1为常温，2为热
     * @param sweetness 甜度类型，0为无糖，2为半糖，2位正常
     * @param price 价格
     * @param topping 无关参数，在咖啡实例中不使用
     * @return 抹茶咖啡或美式咖啡实例
     */
    public Coffee getCoffee(int coffeeType, int temperature, int sweetness, double price, ArrayList<Integer> topping) {
        String tempe = "";
        String sweet = "";

        switch (temperature) {
            case 0:
                tempe = "cool";
                break;
            case 1:
                tempe = "normal";
                break;
            case 2:
                tempe = "hot";
                break;
            default:
                System.out.println("Please enter the right temperature!");
        }

        switch (sweetness) {
            case 0:
                sweet = "free sugar";
                break;
            case 1:
                sweet = "half sugar";
                break;
            case 2:
                sweet = "regular sugar";
                break;
            default:
                System.out.println("Please enter the right sweetness!");
        }

        if (coffeeType == 0) {
            return new MochaCoffee(tempe, sweet, price);
        } else if (coffeeType == 1) {
            return new AmericanCoffee(tempe, sweet, price);
        } else {
            System.out.println("Please enter the right coffee type!");
            return null;
        }
    }

    @Override
    public MilkTea getTea(int teaType, int temperature, int sweetness, double price, ArrayList<Integer> topping) {
        return null;
    }


}
