package goods;

import java.math.BigDecimal;

public class Goods {
	
	private	String id;
	
	private BigDecimal uitPrice;

	
	
	public Goods() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getUitPrice() {
		return uitPrice;
	}

	public void setUitPrice(BigDecimal uitPrice) {
		this.uitPrice = uitPrice;
	}
	
}
