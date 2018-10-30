package goods;

import java.util.ArrayList;

public class MilkTeaFactory extends AbstractFactory {
    public MilkTeaFactory() {
        System.out.println("A milk tea factory constructed.");
    }

    @Override
    public Coffee getCoffee(int coffeeType, int temperature, int sweetness, double price, ArrayList<Integer> topping) {
        return null;
    }

    @Override
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