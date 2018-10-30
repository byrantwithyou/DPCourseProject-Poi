package system.command;

import system.CoffeeRequst;
import system.RequestCategory;
import business.ToolsChain;
import business.orderlist.HomemadeOrderListItem;
import business.orderlist.OrderController;
import goods.homemade.coffee.Coffee;

/**
 * 具体的Command - 制作咖啡
 * @author 马一帆
 * @version 0.1
 */
public class MakeCoffeeCommand implements UncancelCommand {
    private OrderController receiver;
    private static ToolsChain chain = new ToolsChain(2, 4, 2, 1, 2);
    private int type,temperature,sweetness;

    public MakeCoffeeCommand(OrderController receiver, int type, int temperature, int sweetness) {
        this.receiver = receiver;
        this.type = type;
        this.temperature = temperature;
        this.sweetness = sweetness;
    }

    @Override
    public void execute() {

        System.out.println(this.getClass().getName() + " executing\n");
        Coffee coffee = new Coffee();
        CoffeeRequst cfreq = new CoffeeRequst(RequestCategory.makeCoffe, coffee, type,temperature,sweetness, (type+10)*2);
        chain.receiveReq(cfreq);
        HomemadeOrderListItem coffeeItem = new HomemadeOrderListItem("100001",1,coffee);
        receiver.addItem(coffeeItem);
    }
    
}
