package business;

/**
 * 具体的Command - 制作咖啡
 * @author 马一帆
 * @version 0.1
 */
public class MakeCoffeeCommand implements UncancelCommand {
    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " executing\n");
    }
}