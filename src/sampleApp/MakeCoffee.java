package sampleApp;
//设计模式：Factory
import system.CoffeeRequst;
import system.RequestCategory;
import business.ToolsChain;
import goods.homemade.coffee.Coffee;
import tools.maker.CoffeeMaker;

import java.util.*;

public class MakeCoffee {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
		CoffeeMaker coffeeMaker;
        @SuppressWarnings("unused")
		CoffeeRequst coffeeRequst;
        ToolsChain chain = new ToolsChain(2, 4, 2, 1, 2);
        Coffee coffee = new Coffee();
        System.out.println("*************************************");
        System.out.println("       输入数字选择你想获取的咖啡：");
        System.out.println("0】美式咖啡 1】卡布奇诺 2】摩卡咖啡");
        Integer i = 0;
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        System.out.println("       输入数字选择你想要的温度：");
        System.out.println("0】低温 1】常温 2】加热");
        Integer j = 0;
        j = scanner.nextInt();
        System.out.println("       输入数字选择你想要的甜度：");
        System.out.println("0】无糖 1】半糖 2】正常");
        Integer k = 0;
        k = scanner.nextInt();
        CoffeeRequst cfreq = new CoffeeRequst(RequestCategory.makeCoffe, coffee, i, j, k, 10);
        if(chain.receiveReq(cfreq)){
            System.out.println(coffee.getName()+"\n"+coffee.getTemperature()+"\n"+coffee.getSweetness()+"\n"+coffee.getPrice());
        }
        else{
            System.out.println("未完成");
        }
    }
}
