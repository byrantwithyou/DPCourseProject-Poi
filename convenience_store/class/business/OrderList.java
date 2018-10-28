package business;

public class OrderList {
	
	private String[] list;
	
	private int visitor_id;
	
	private boolean state;
	
	
	
	public OrderList() {
	}
	
	public OrderList(int vid) {
	}
	
	public boolean isClosed() {
		return state;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	public int getVisitor_id() {
		return visitor_id;
	}

	public void setVisitor_id(int visitor_id) {
		this.visitor_id = visitor_id;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
}
