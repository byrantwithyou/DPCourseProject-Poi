package business.orderlist;

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
		System.out.println(this.getClass().getSimpleName() + ":(" + vid + "): Constructor called : is created");
		list = new ArrayList<>();
	}
	
	public ArrayList<OrderListItem> getOrder(){
		return list;
	}
	
	public boolean isClosed() {
		return state;
	}

	public int getVisitorId() {
		return visitorID;
	}

	public void setVisitorId(int visitorId) {
		this.visitorID = visitorId;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public void addItem(OrderListItem item) {
		System.out.println(this.getClass().getSimpleName() + " :(" + visitorID + ") :"
				+ "addItem method is called : Adding item " + item.getGoodsID());
		for(OrderListItem i:list) {
			if(i.getGoodsID().equals(item.getGoodsID())) {
				i.addAmount();
				return;
			}
		}
		list.add(item);
	}

	public void removeItem(String id) {
		System.out.println(this.getClass().getSimpleName() + " :(" + visitorID + ") :"
				+ "removeItem method is called : removing item " + id);
		list.removeIf(item -> item.getGoodsID().equals(id));
	}

	//Memento
	public OrderListMemento createMemento() throws CloneNotSupportedException {
		System.out.println(this.getClass().getSimpleName() + " :(" + visitorID + ") :"
				+ "createMemento method is called : creating memento for order list");
		return new OrderListMemento(list,state);
	}

	public void reinstateMemento(OrderListMemento memento) throws CloneNotSupportedException {
		System.out.println(this.getClass().getSimpleName() + " :(" + visitorID + ") :"
				+ "reinstateMemento method is called : recovering..");
		list = new ArrayList<>(); //原来的就交给垃圾回收器啦
		for(OrderListItem item:memento.listState) {
			list.add(item.clone());
		}
		state = memento.orderState;
	}

}
