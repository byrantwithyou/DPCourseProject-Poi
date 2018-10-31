package goods.homemade.milktea;

import java.util.ArrayList;

import goods.homemade.AbstractFactory;
import goods.homemade.coffee.Coffee;

public class MilkTeaFactory extends AbstractFactory {
    public MilkTeaFactory() {
        System.out.println("A milk tea factory constructed.");
    }

    @Override
    public Coffee getCoffee(int coffeeType, int temperature, int sweetness, double price, ArrayList<Integer> topping) {
        return null;
    }

    @Override
    /**
     * 通过奶茶工厂获得相应的奶茶实例
     * @param coffeeType 奶茶类型，0为红奶茶，1位绿奶茶
     * @param temperature 温度类型，0为冰，1为常温，2为热
     * @param sweetness 甜度类型，0为无糖，2为半糖，2位正常
     * @param price 价格
     * @param topping 加料列表，0为椰果，1为布丁，2为红豆
     * @return 红奶茶或绿奶茶实例
     */
    public MilkTea getTea(int teaType, int temperature, int sweetness, double price, ArrayList<Integer> topping) {
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


        if (teaType == 0) {
            return new RedMilkTea(tempe, sweet, price, topping);
        } else if (teaType == 1) {
            return new GreenMilkTea(tempe, sweet, price, topping);
        } else {
            System.out.println("Please enter the right milk tea type!");
            return null;
        }
    }
}
