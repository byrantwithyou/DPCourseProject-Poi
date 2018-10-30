package goods;
/**
 * 冰激凌实体类 桥接模式之实现
 * @author Sun
 * @version 0.0.1
 *
 */
import business.MakeIceCream;
import business.MakeVanillaIceCream;
import business.MakeChocoIceCream;
public class IceCream extends HomemadeGoods {
	private MakeIceCream command;
	private String size;
	private String category;
	public IceCream(String category, String size) {
		this.category = category;
		this.size = size;
	}
	public void orderIceCream() {
		if (category == "Vanilla") {
			command = new MakeVanillaIceCream();
		}
		else {
			command = new MakeChocoIceCream();
		}
		command.execute();
		System.out.println(this.size);
	}
	public static void main(String[] args) {
		IceCream a = new IceCream("Vanilla", "Big");
		IceCream b = new IceCream("Chocolate", "Small");
		a.orderIceCream();
		b.orderIceCream();
	}
}
