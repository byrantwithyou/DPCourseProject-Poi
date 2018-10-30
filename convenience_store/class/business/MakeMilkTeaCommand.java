package business;

import business.interpreter.MilkTeaPriceGetter;
import goods.HomemadeGoods;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 具体的Command
 * @author 马一帆
 * @version 0.1
 */
public class MakeMilkTeaCommand implements UncancelCommand{
    private OrderController receiver;
    String options;

    public MakeMilkTeaCommand(OrderController receiver, String options) {
        this.receiver = receiver;
        this.options = options;
    }

    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " executing\n");

        String[] groupOptions = options.split("&|\\+");
        HomemadeGoods goods = new HomemadeGoods();
        int[] adds = Arrays.stream(Arrays.copyOfRange(groupOptions,3,6)).mapToInt(Integer::parseInt).toArray();
        goods.setUitPrice(MilkTeaPriceGetter.getPrice(Integer.parseInt(groupOptions[0]),
                Integer.parseInt(groupOptions[1]),Integer.parseInt(groupOptions[2]), adds));
        HomemadeOrderListItem item = new HomemadeOrderListItem("0",1,goods);
        receiver.addItem(item);
        receiver.updateView();
    }
}
