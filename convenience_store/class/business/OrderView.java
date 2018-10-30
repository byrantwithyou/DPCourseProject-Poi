package business;
import java.util.ArrayList;
public class OrderView {
	public void printOrder(ArrayList<OrderListItem> list) {
		list.forEach(OrderListItem::printOut);
	}
}
