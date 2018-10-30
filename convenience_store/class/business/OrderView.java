package business;
import visitor.ConcreteVisitor;

import java.util.ArrayList;
public class OrderView {
	private static ConcreteVisitor goodsInfoGetter = new ConcreteVisitor();

	public void printOrder(ArrayList<OrderListItem> list,int visitorID,boolean state) {
		System.out.println("---   Current Order List   ---");
		System.out.println("Completed:" + state + "  Visitor " + visitorID + "");
		list.forEach(OrderListItem::printOut);
		System.out.println("--------------------------------");
	}
}
