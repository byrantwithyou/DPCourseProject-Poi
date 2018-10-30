package sampleApp;

import goods.homemade.icecream.IceCream;

/**
 * 桥接模式sample0
 * @author Sun
 * @version 0.0.1
 */
public class BridgeSample2 {
	public static void main(String[] args) {
		IceCream a = new IceCream("Chocolate", "Small");
		a.printOut();
	}
}