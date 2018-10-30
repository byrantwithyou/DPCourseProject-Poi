package business.orderlist;

public class OrderController {
	private OrderList order;
	private OrderView view;
	
	public OrderController(OrderList order, OrderView view) {
		this.order = order;
		this.view = view;
	}
	
	public void addItem(OrderListItem item) {
		order.addItem(item);
		updateView();
	}
	
	public void removeItem(String id) {
		order.removeItem(id);
		updateView();
	}

	public OrderListMemento createMemento() throws CloneNotSupportedException {
		return order.createMemento();
	}

	public void reinstateMemento(OrderListMemento memento) throws CloneNotSupportedException {
		order.reinstateMemento(memento);
	}


	public void updateView() {
		view.printOrder(order.getOrder(),order.getVisitorId(),order.getState());
	}
}
