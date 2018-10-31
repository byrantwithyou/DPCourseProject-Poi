package goods.homemade;

import goods.homemade.coffee.CoffeeFactory;
import goods.homemade.milktea.MilkTeaFactory;

public class FactoryProducer {
    private static FactoryProducer fp;

    /**
     * 将构造函数设为private，避免外部创建
     */
    private FactoryProducer() {
    }

    /**
     * 创建唯一一个FactoryProducer实例
     * @return fp FactoryProducer实例
     */
    public static FactoryProducer instance() {
        if (fp == null) {
            fp = new FactoryProducer();
            System.out.println("A factory producer is constructed.");
        }else{
            System.out.println("Only one factory producer can be constructed!");
        }
        return fp;
    }

    /**
     * 根据输入的工厂类型，创建相应的工厂实例
     * @param choice 工厂类型，0为咖啡工厂，1为奶茶工厂
     * @return 相应的工厂实例
     */
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
