package business;

import java.util.ArrayList;

/**
 * 收银台当前正在处理的结帐单
 */
public class OrderList{
	
	private ArrayList<OrderListItem> list;
	
	private int visitorID;
	
	private boolean state; //约定true已完成咯

	public OrderList() {
	}
	
	public OrderList(int vid) {
		list = new ArrayList<>();
	}
	
	public boolean isClosed() {
		return state;
	}

	public int getVisitor_id() {
		return visitorID;
	}

	public void setVisitor_id(int visitor_id) {
		this.visitorID = visitor_id;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public void addItem(OrderListItem item) {
		for(OrderListItem i:list) {
			if(i.getGoodsID().equals(item.getGoodsID())) {
				i.addAmount();
				return;
			}
		}
		list.add(item);
	}

	public void removeItem(String id) {
		list.removeIf(item -> item.getGoodsID().equals(id));
	}

	//Memento
	public OrderListMemento createMemento() throws CloneNotSupportedException {
		return new OrderListMemento(list,state);
	}

	public void reinstateMemento(OrderListMemento memento) throws CloneNotSupportedException {
		list = new ArrayList<>(); //原来的就交给垃圾回收器啦
		for(OrderListItem item:memento.listState) {
			list.add(item.clone());
		}
		state = memento.orderState;
	}

	public void printAll() {
		System.out.println("---   Current Order List   ---");
		System.out.println("Completed:" + state + "  Visitor " + visitorID + "");
		list.forEach(OrderListItem::printOut);
		System.out.println("--------------------------------");
	}

}
