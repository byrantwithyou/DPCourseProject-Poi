package sampleApp;

import goods.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FactorySample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FactoryProducer fp = FactoryProducer.instance();

        System.out.println("Please enter factory type: ");
        int factory_type = in.nextInt();
        AbstractFactory factory = fp.getFactory(factory_type);

        double price = 12.00;
        int type = 0;
        int temperature = 0;
        int sweetness = 0;
        int topping = 0;
        ArrayList<Integer> toppings = new ArrayList<>();

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter parameters, enter 9 to end: (example: 0 2 1 12.00 1 2)");
            type = in.nextInt();
            temperature = in.nextInt();
            sweetness = in.nextInt();
            price = in.nextDouble();
            while (topping != 9) {
                topping = in.nextInt();
                toppings.add(topping);
            }

            HomemadeGoods a_= new HomemadeGoods();
            if (factory_type == 0) {
                a_ = factory.getCoffee(type, temperature, sweetness, price, toppings);
            } else if (factory_type == 1) {
                a_ = factory.getTea(type, temperature, sweetness, price, toppings);
            }

            a_.printOut();

            System.out.println("Want another cup? [y/n]");
            choice = in.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}
