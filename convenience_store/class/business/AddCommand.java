package business;

/**
 * 具体的一个command,添加新的商品条目至当前结账单orderlist
 * @author 马一帆
 * @version 0.1
 */
public class AddCommand implements CancelableCommand {
    private OrderList receiver;
    private OrderListItem item;
    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " executing");
        System.out.println("Add item " + item.getGoodsID() + " to current list");
        receiver.addItem(item);
        receiver.printAll();
    }

    public OrderList getReceiver() {
        return receiver;
    }

    public void setReceiver(OrderList receiver) {
        this.receiver = receiver;
    }

    public AddCommand(String goodsID) {
        item = new OrderListItem(goodsID,1);
    }
}
