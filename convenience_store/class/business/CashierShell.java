package business;

import com.sun.tools.javac.Main;
import goods.IceCream;
import visitor.ConcreteVisitor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 收银台交互 遵循单例模式
 * @author 马一帆
 * @version 0.1
 */
public class CashierShell {
	private static final int cancelableTypes = 2;
	private static final int uncancelTypes = 1;
	private static final int LIST_LENGTH = 20;
	private static ArrayList<CancelableCommand> commandsList;
	private static ArrayList<OrderListMemento> mementoList;
	private static CashierShell shellInstance = null;
	private static OrderList currentList; //结帐单存储结构
	private static OrderController listController;
	private static OrderView orderView;


	static int numCommands; //当前列表内command的数量
	static int highWater; //当前状态表内数量

	private CashierShell() {
	}

	public static void runCommand(Command inputCommand) throws CloneNotSupportedException {
		//无法恢复的Command直接执行
		if(inputCommand instanceof UncancelCommand) {
			inputCommand.execute();
			return;
		}

		assert (inputCommand instanceof CancelableCommand) : "Command type error";

		if(highWater < numCommands)
			highWater = numCommands;

		//首先记录当前结帐单状态
		mementoList.add(highWater,currentList.createMemento());
		//储存command
		commandsList.add(numCommands,(CancelableCommand) inputCommand);

		numCommands++;
		inputCommand.execute();
	}

	public static void undo() throws CloneNotSupportedException {
		if(numCommands == 0) {
			System.out.println("--- 已至可恢复末尾 ---\n");
			return;
		}
		System.out.println(CashierShell.getInstance().getClass().getName() + " undo last command");
		//CancelableCommand command = commandsList.get(numCommands - 1);
		//应该获取receiver的，下面这样处理不太好
		currentList.reinstateMemento(mementoList.get(numCommands - 1));
		numCommands--;

	}

	public static void redo() {
		if(numCommands > highWater || commandsList.size() == 0) {
			System.out.println("--- 已至可重做末尾 ---\n");
			return;
		}
		System.out.println(CashierShell.getInstance().getClass().getName() + " redo last command");
		commandsList.get(numCommands).execute();
		numCommands++;
	}

	public static CashierShell getInstance() {
		if(shellInstance != null) {
			return shellInstance;
		} else {
			shellInstance = new CashierShell();
			commandsList = new ArrayList<>(LIST_LENGTH);
			mementoList = new ArrayList<>(LIST_LENGTH);
			currentList = new OrderList(0);
			orderView = new OrderView();
			listController = new OrderController(currentList,orderView);
			numCommands = highWater = 0;
			return shellInstance;
		}
	}

	//Commands与Memento单元测试
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Welcome, input commands to do something");
		System.out.println("add [id]		| 扫码加入商品\n" +
							"rm [id]		| 移除商品\n" +
							"undo		| 撤销\n" +
							"redo		| 重做\n" +
							"print		| 打印当前结帐单内容\n" +
							"mkNew		| 新的顾客\n" +
							"mkCoffee		| 添加制作咖啡\n" +
							"mkMTea		| 添加制作奶茶\n" +
							"mkIceCream	[type] [size]	| 添加制作冰激淋\n" +
							"showDepart [id]		| 展示 id 号经理下所有员工\n" +
							"add");
		String input;
		Scanner scanner = new Scanner(System.in);
		CashierShell shell = CashierShell.getInstance();
		while (scanner.hasNext()) {
			input = scanner.nextLine();
			String[] orders = input.split(" ");

			System.out.println("Your input:" + orders[0]);

			if(orders[0].equals("add")) {
				AddCommand addCommand = new AddCommand(orders[1]);
				addCommand.setReceiver(listController);
				CashierShell.runCommand(addCommand);
				continue;
			}

			if (orders[0].equals("rm")) {
				RemoveCommand removeCommand = new RemoveCommand(orders[1]);
				removeCommand.setReceiver(listController);
				CashierShell.runCommand(removeCommand);
				continue;
			}

			if (orders[0].equals("redo")) {
				CashierShell.redo();
				continue;
			}

			if (orders[0].equals("undo")) {
				CashierShell.undo();
				CashierShell.listController.updateView();
				continue;
			}

			if (orders[0].equals("mkCoffee")) {
				//转换传入各个参数
				MakeCoffeeCommand mkCoffeeCommand = new MakeCoffeeCommand(CashierShell.listController,
						Integer.parseInt(orders[1]), Integer.parseInt(orders[2]), Integer.parseInt(orders[3]));
				CashierShell.runCommand(mkCoffeeCommand);
				continue;
			}

			if (orders[0].equals("mkMTea")) {
				System.out.println("正在添加一杯奶茶，请输入制作参数命令");
				System.out.println(" 0.RedMilkTea 1.GreenMilkTea\n" +
						" 0.cool 1.normal 2.hot\n" +
						" 0.freesugar 1.halfsugar 2.regularsugar\n" +
						" 0.coconut 1.pudding 2.bean");
				MakeMilkTeaCommand mkTeaCommand = new MakeMilkTeaCommand(CashierShell.listController,scanner.nextLine());
				CashierShell.runCommand(mkTeaCommand);
				continue;
			}
			if (orders[0].equals("print")) {
				CashierShell.listController.updateView();
				continue;
			}

			if (orders[0].equals("mkNew")) {
				CashierShell.currentList = new OrderList(0);
				CashierShell.orderView = new OrderView();
				CashierShell.listController = new OrderController(CashierShell.currentList, CashierShell.orderView);
				continue;
			}

			if (orders[0].equals("mkIceCream")) {
				if(orders[1].equals("0")) {
					IceCream iceCream = new IceCream("Vanilla",orders[2]);
					HomemadeOrderListItem item = new HomemadeOrderListItem("100002", 1, iceCream);
					CashierShell.listController.addItem(item);
				} else if(orders[1].equals("1")){
					IceCream iceCream = new IceCream("Chocolate",orders[2]);
					HomemadeOrderListItem item = new HomemadeOrderListItem("100003", 1, iceCream);
					CashierShell.listController.addItem(item);
				}
				continue;
			}


		}
	}
}
