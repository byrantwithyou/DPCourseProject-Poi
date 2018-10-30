package business;

import business.interpreter.MilkTeaPriceGetter;
import goods.AbstractFactory;
import goods.HomemadeGoods;
import goods.MilkTea;
import goods.MilkTeaFactory;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 具体的Command
 * @author 马一帆
 * @version 0.1
 */
public class MakeMilkTeaCommand implements UncancelCommand{
    private OrderController receiver;
    private static MilkTeaFactory factory = new MilkTeaFactory();
    String options;

    public MakeMilkTeaCommand(OrderController receiver, String options) {
        this.receiver = receiver;
        this.options = options;
    }

    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " executing\n");

        String[] groupOptions = options.split("&|\\+");
//        HomemadeGoods goods = new HomemadeGoods();
////        int[] adds = Arrays.stream(Arrays.copyOfRange(groupOptions,3,6)).mapToInt(Integer::parseInt).toArray();
////        goods.setUitPrice(MilkTeaPriceGetter.getPrice(Integer.parseInt(groupOptions[0]),
////                Integer.parseInt(groupOptions[1]),Integer.parseInt(groupOptions[2]), adds));
        int[] adds = Arrays.stream(Arrays.copyOfRange(groupOptions,3,6)).mapToInt(Integer::parseInt).toArray();
        int type = Integer.parseInt(groupOptions[0]);
        int temparure = Integer.parseInt(groupOptions[1]);
        int sugar = Integer.parseInt(groupOptions[2]);
        BigDecimal price = (MilkTeaPriceGetter.getPrice(type, temparure, sugar, adds));
        //以下，调用其他设计模式的接口
        ArrayList<Integer> addsArrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (adds[i] == 1) {
                addsArrayList.add(i);
            }
        }
        MilkTea teaInstance = factory.getTea(type,temparure,sugar,price.doubleValue(),addsArrayList);

        HomemadeOrderListItem item = new HomemadeOrderListItem("0",1,teaInstance);
        receiver.addItem(item);
    }
}
