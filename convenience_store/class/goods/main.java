package goods;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FactoryProducer fp = FactoryProducer.instance();

        System.out.println("Please enter factory type: ");
        int factory_type = in.nextInt();
        AbstractFactory factory = fp.getFactory(factory_type);

        ArrayList<Integer> toppings = new ArrayList<>();
        toppings.add(0);
        toppings.add(2);

        factory.getTea(0,2,1,12.00,toppings);
        factory.getCoffee(0,2,1,12.00,toppings);
    }
}
