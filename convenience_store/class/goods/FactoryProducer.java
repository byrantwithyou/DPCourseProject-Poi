package goods;

public class FactoryProducer {
    private static FactoryProducer fp;

    /**
     * 将构造函数设为private，避免外部创建
     */
    private FactoryProducer() {
    }

    public static FactoryProducer instance() {
        if (fp == null) {
            fp = new FactoryProducer();
        }
        return fp;
    }

    public AbstractFactory getFactory(int choice) {
        if (choice == 0) {
            return new CoffeeFactory();
        } else if (choice == 1) {
            return new MilkTeaFactory();
        } else {
            System.out.println("Please enter the right factory number!");
        }
        return null;
    }
}
