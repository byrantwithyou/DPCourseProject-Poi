package system.command;
/**
 * 制作香草冰激凌
 * @author Administrator
 * @version 0.0.1
 */
public class MakeVanillaIceCream implements MakeIceCream{
	public void execute() {
		System.out.println(this.getClass().getSimpleName()
				+ ": ()" + "execute method is called: executing..");
		System.out.println("VanillaIceCream is Created!");
	}
}
