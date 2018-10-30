package business;

public class OrderController {
	private OrderList order;
	private OrderView view;
	
	public OrderController(OrderList order, OrderView view) {
		this.order = order;
		this.view = view;
	}
	
	public void addItem(String goodsId, int amount) {
		order.addItem(new OrderListItem(goodsId, amount));
		updateView();
	}
	
	public void removeItem(String id) {
		order.removeItem(id);
		updateView();
	}
	
	public void updateView() {
		view.printOrder(order.getOrder());
	}
}
