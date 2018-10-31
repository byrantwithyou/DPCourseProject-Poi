package sampleApp;


//设计模式:MVC、Memento Command 、Chain of responsibility、Template Method 
import goods.homemade.icecream.IceCream;
import goods.stock.FlyweightPattern;
import system.command.AddCommand;
import system.command.CancelableCommand;
import system.command.Command;
import system.command.MakeCoffeeCommand;
import system.command.MakeMilkTeaCommand;
import system.command.RemoveCommand;
import system.command.UncancelCommand;
import tools.adboard.AdDisplayBoard;
import tools.adboard.AdTerminal;
import tools.adboard.Advertisement;
import tools.adboard.PicAdvertisement;
import tools.adboard.VideoAdvertisement;
import tools.scanner.RealScanner;
import workers.Manager;


import java.util.ArrayList;
import java.util.Scanner;

import business.orderlist.HomemadeOrderListItem;
import business.orderlist.OrderController;
import business.orderlist.OrderList;
import business.orderlist.OrderListMemento;
import business.orderlist.OrderView;

/**
 * Application 面向收银台的用户级应用
 * @author 马一帆
 * @version 0.1
 */
public class MainCashierShell {
	private static final int cancelableTypes = 2;
	private static final int uncancelTypes = 1;
	private static final int LIST_LENGTH = 20;
	private static ArrayList<CancelableCommand> commandsList;
	private static ArrayList<OrderListMemento> mementoList;
	private static MainCashierShell shellInstance = null;
	private static OrderList currentList; //结帐单存储结构
	private static OrderController listController;
	private static OrderView orderView;

	private static RealScanner codeScanner = new RealScanner();
	private static ArrayList<Manager> managers = new ArrayList<>();

	static int numCommands; //当前列表内command的数量
	static int highWater; //当前状态表内数量

	private MainCashierShell() {
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
		System.out.println(MainCashierShell.getInstance().getClass().getName() + " undo last command");
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
		System.out.println(MainCashierShell.getInstance().getClass().getName() + " redo last command");
		commandsList.get(numCommands).execute();
		numCommands++;
	}

	public static MainCashierShell getInstance() {
		if(shellInstance != null) {
			return shellInstance;
		} else {
			shellInstance = new MainCashierShell();
			commandsList = new ArrayList<>(LIST_LENGTH);
			mementoList = new ArrayList<>(LIST_LENGTH);
			currentList = new OrderList(0);
			orderView = new OrderView();
			listController = new OrderController(currentList,orderView);

			//加入一些默认经理和员工
			managers.add(new Manager("1001","Ayase Manager"));
			managers.get(0).addFollower("5001","Gakki");
			managers.get(0).addFollower("5002","Yui");

			//加入一个默认广告牌
			AdTerminal.getInstance().addAdDisplayBoard(new AdDisplayBoard());

			numCommands = highWater = 0;
			return shellInstance;
		}
	}

	//Commands与Memento单元测试
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Welcome, input commands to do something");
		System.out.println("add [id]		| 扫码加入商品 id:000001~000005\n" +
							"printLogo [id] | 打印id商品的图片描述\n" +
							"rm [id]		| 移除商品\n" +
							"undo		| 撤销\n" +
							"redo		| 重做\n" +
							"print		| 打印当前结帐单内容\n" +
							"mkNew		| 新的顾客\n" +
							"mkCoffee [type] [temperature] [sugar degree] | 添加制作咖啡\n" +
							"mkMTea		| 添加制作奶茶\n" +
							"mkIceCream	[type] [size]	| 添加制作冰激淋 Type:0-Vanilla 1-Chocolate\n" +
							"addManager [id] [name]	| 添加经理\n" +
							"showDepart [id]		| 展示 id 号经理下所有员工\n" +
							"addEmployee [mid] [id] [name] | 在 mid 号经理下加入id name员工\n" +
							"addAdBoard 			| 添加广告牌\n" +
							"showAd [type] [brand] [slogan]		| 所有广告牌上显示广告 Type:PicAd/VideoAd");
		String input;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		@SuppressWarnings("unused")
		MainCashierShell shell = MainCashierShell.getInstance();
		while (scanner.hasNext()) {
			input = scanner.nextLine();
			String[] orders = input.split(" ");

			System.out.println("Your input:" + orders[0]);

			if(orders[0].equals("add")) {
				codeScanner.scan("BarCode",orders[1]);
				AddCommand addCommand = new AddCommand(orders[1]);
				addCommand.setReceiver(listController);
				MainCashierShell.runCommand(addCommand);
				continue;
			}

			if (orders[0].equals("rm")) {
				RemoveCommand removeCommand = new RemoveCommand(orders[1]);
				removeCommand.setReceiver(listController);
				MainCashierShell.runCommand(removeCommand);
				continue;
			}

			if (orders[0].equals("redo")) {
				MainCashierShell.redo();
				continue;
			}

			if (orders[0].equals("undo")) {
				MainCashierShell.undo();
				MainCashierShell.listController.updateView();
				continue;
			}

			if (orders[0].equals("mkCoffee")) {
				//转换传入各个参数
				MakeCoffeeCommand mkCoffeeCommand = new MakeCoffeeCommand(MainCashierShell.listController,
						Integer.parseInt(orders[1]), Integer.parseInt(orders[2]), Integer.parseInt(orders[3]));
				MainCashierShell.runCommand(mkCoffeeCommand);
				continue;
			}

			if (orders[0].equals("mkMTea")) {
				System.out.println("正在添加一杯奶茶，请输入制作参数命令");
				System.out.println(" 0.RedMilkTea 1.GreenMilkTea\n" +
						" 0.cool 1.normal 2.hot\n" +
						" 0.freesugar 1.halfsugar 2.regularsugar\n" +
						" 0.coconut 1.pudding 2.bean");
				MakeMilkTeaCommand mkTeaCommand = new MakeMilkTeaCommand(MainCashierShell.listController,scanner.nextLine());
				MainCashierShell.runCommand(mkTeaCommand);
				continue;
			}
			if (orders[0].equals("print")) {
				MainCashierShell.listController.updateView();
				continue;
			}

			if (orders[0].equals("mkNew")) {
				MainCashierShell.currentList = new OrderList(0);
				MainCashierShell.orderView = new OrderView();
				MainCashierShell.listController = new OrderController(MainCashierShell.currentList, MainCashierShell.orderView);
				continue;
			}

			if (orders[0].equals("mkIceCream")) {
				if(orders[1].equals("0")) {
					IceCream iceCream = new IceCream("Vanilla",orders[2]);
					HomemadeOrderListItem item = new HomemadeOrderListItem("100002", 1, iceCream);
					MainCashierShell.listController.addItem(item);
				} else if(orders[1].equals("1")){
					IceCream iceCream = new IceCream("Chocolate",orders[2]);
					HomemadeOrderListItem item = new HomemadeOrderListItem("100003", 1, iceCream);
					MainCashierShell.listController.addItem(item);
				}
				continue;
			}

			if(orders[0].equals("addManager")) {
				Manager m = new Manager(orders[1],orders[2]);
				managers.add(m);
				System.out.println("添加成功，当前所有经理");
				managers.forEach(item -> System.out.println(item.getId() + "  name:" + item.getName()));
				continue;
			}
			if (orders[0].equals("showDepart")) {
				managers.forEach(item -> {
					if(item.getId().equals(orders[1]))
						item.printOut();
				});
				continue;
			}

			if (orders[0].equals("addEmployee")) {
				managers.forEach(item -> {
					if (item.getId().equals(orders[1]))
						item.addFollower(orders[2],orders[3]);
				});
				continue;
			}

			if (orders[0].equals("addAdBoard")) {
				AdTerminal.getInstance().addAdDisplayBoard(new AdDisplayBoard());
				System.out.println("添加成功 现有广告牌数量 " + AdTerminal.getInstance().getBoardsAmount());
				continue;
			}

			if (orders[0].equals("showAd")) {
				Advertisement advertisement;
				if(orders[1].equalsIgnoreCase("PicAd")) {
					advertisement = new PicAdvertisement(orders[2], orders[3]);
					AdTerminal.getInstance().showAd(advertisement);
				} else if (orders[1].equalsIgnoreCase("VideoAd")) {
					advertisement = new VideoAdvertisement(orders[2], orders[3]);
					AdTerminal.getInstance().showAd(advertisement);
				} else {
					System.out.println("Error! Invalid Type of Advertisement");
				}
				continue;
			}

			if(orders[0].equals("printLogo")) {
				FlyweightPattern flyweightPattern=new FlyweightPattern();
				flyweightPattern.showFlyweight(orders[1]);
				continue;
			}
		}
	}

	public static int getCancelabletypes() {
		return cancelableTypes;
	}

	public static int getUncanceltypes() {
		return uncancelTypes;
	}
}
