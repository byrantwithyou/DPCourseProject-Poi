package system.command;

import business.orderlist.OrderController;
import business.orderlist.OrderListItem;

/**
 * 具体的一个command,添加新的商品条目至当前结账单orderlist
 * @author 马一帆
 * @version 0.1
 */
public class AddCommand implements CancelableCommand {
    private OrderController receiver;
    private OrderListItem item;
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName()
                + ": ():" + " execute method is called: executing..");
        System.out.println(this.getClass().getName() + " command executing");
        System.out.println(this.getClass().getSimpleName() + "Add item " + item.getGoodsID() + " to current list");
        receiver.addItem(item);
    }

    public void setReceiver(OrderController receiver) {
        this.receiver = receiver;
    }

    public AddCommand(String goodsID) {
        item = new OrderListItem(goodsID,1);
    }
}
