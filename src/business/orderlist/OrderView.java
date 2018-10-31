package business.orderlist;

import java.util.ArrayList;


public class OrderView {


	public void printOrder(ArrayList<OrderListItem> list,int visitorID,boolean state) {
		System.out.println(this.getClass().getSimpleName() + " :(" + visitorID + ") :"
				+ "printOrder method is called : printing order..");
		
		System.out.println("---   Current Order List   ---");
		System.out.println("Completed:" + state + "  Visitor " + visitorID + "");
		list.forEach(OrderListItem::printOut);
		System.out.println("--------------------------------");
	}
}
