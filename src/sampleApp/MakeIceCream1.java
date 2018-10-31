package sampleApp;

import goods.homemade.icecream.IceCream;

/**
 * 桥接模式sample0
 * @author Sun
 * @version 0.0.1
 */
public class MakeIceCream1 {
	public static void main(String[] args) {
		IceCream a = new IceCream("Vanilla", "Small");
		a.printOut();
	}
}
