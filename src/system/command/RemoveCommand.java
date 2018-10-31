package system.command;

import business.orderlist.OrderController;

/**
 * 具体的一个command,从当前结帐单移除一个商品条目
 * @author 马一帆
 * @version 0.1
 */
public class RemoveCommand  implements CancelableCommand{
    private String goalID;
    private OrderController receiver;

    public RemoveCommand(String goalID) {
        this.goalID = goalID;
    }

    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " executing\n");
        System.out.println("Remove item " + goalID + "from current list");
        receiver.removeItem(goalID);
    }

    public void setReceiver(OrderController receiver) {
        this.receiver = receiver;
    }

}
