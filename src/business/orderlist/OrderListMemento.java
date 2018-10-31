package business.orderlist;

import java.util.ArrayList;

/**
 * Orderlist 状态捕捉快照，注意必须与orderlist位于同一包下
 * @author 马一帆
 * @version 0.1
 */
public class OrderListMemento {
    ArrayList<OrderListItem> listState;
    boolean orderState;
    public OrderListMemento(ArrayList<OrderListItem> list,boolean currentState) throws CloneNotSupportedException {
        System.out.println(this.getClass().getSimpleName()
                + " OrderListMemento method is called: Constructor called : new memento is created");
        listState = new ArrayList<>();
        for (OrderListItem item:list) {
            listState.add(item.clone());
        }
        orderState = currentState;
    }
}
