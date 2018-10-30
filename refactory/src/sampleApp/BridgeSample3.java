package sampleApp;

import goods.homemade.icecream.IceCream;

/**
 * 桥接模式sample0
 * @author Sun
 * @version 0.0.1
 */
public class BridgeSample3 {
	public static void main(String[] args) {
		IceCream a = new IceCream("Chocolate", "Big");
		a.printOut();
	}
}