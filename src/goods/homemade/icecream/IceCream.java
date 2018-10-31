package goods.homemade.icecream;
/**
 * 冰激凌实体类 桥接模式之实现
 * @author Sun
 * @version 0.0.1
 *
 */
import goods.homemade.icecream.MakeIceCream;
import goods.homemade.icecream.MakeVanillaIceCream;
import goods.homemade.HomemadeGoods;
import goods.homemade.icecream.MakeChocoIceCream;
public class IceCream extends HomemadeGoods {
	private MakeIceCream command;
	private String size;
	private String category;
	private double price = 30.0;
	public IceCream(String category, String size) {
		this.category = category;
		this.size = size;
		if (category.equals("Vanilla")) {
			this.price = 20.0;
		}
		if (size .equals( "Small")) {
			this.price = this.price * 0.75;
		}
	}
	@Override
	public void printOut() {
		if (category.equals("Vanilla")) {
			command = new MakeVanillaIceCream();
		}
		else {
			command = new MakeChocoIceCream();
		}
		command.execute();
		System.out.printf(" A %s one!", size);
		System.out.printf(" Price: %s\n", price);
	}
	public static void main(String[] args) {
		IceCream a = new IceCream("Vanilla", "Big");
		IceCream b = new IceCream("Chocolate", "Small");
		a.printOut();
		b.printOut();
	}
}
