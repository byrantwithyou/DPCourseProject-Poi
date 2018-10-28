package goods;

import tools.Tools;

public class HomemadeGoods extends Goods {
	
	private Tools maker;
	
	

	public HomemadeGoods() {
	}
	
	public boolean isAvailable() {
		return true;
	}
	
	public Tools getMaker() {
		return maker;
	}

	public void setMaker(Tools maker) {
		this.maker = maker;
	}

	
}
