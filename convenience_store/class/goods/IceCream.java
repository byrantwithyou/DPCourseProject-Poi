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
	public IceCream(MakeIceCream command) {
		this.command = command;
	}
	public void orderIceCream() {
		command.execute();
	}
	public static void main(String[] args) {
		IceCream a = new IceCream(new MakeVanillaIceCream());
		IceCream b = new IceCream(new MakeChocoIceCream());
		a.orderIceCream();
		b.orderIceCream();
	}
}
