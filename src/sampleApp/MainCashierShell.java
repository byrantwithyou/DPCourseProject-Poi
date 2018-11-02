package sampleApp;



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
 * Total Application Tester
 */

public class MainCashierShell {
	private static MainCashierShell shellInstance = null;
	//测试单例模式
	private static OrderListManager orderListManager = OrderListManager.getInstance();

	private static RealScanner codeScanner = new RealScanner();
	private static ArrayList<Manager> managers = new ArrayList<>();


	private MainCashierShell() {
	}

	public static MainCashierShell getInstance() {
		if(shellInstance != null) {
			return shellInstance;
		} else {
			System.out.println("MainCashierShell" + "("
					+ ")： Constructor called :" + " single instance is created");
			shellInstance = new MainCashierShell();

			orderListManager = OrderListManager.getInstance();
			//加入一些默认的经理和员工
			managers.add(new Manager("1001","Ayase Manager"));
			managers.get(0).addFollower("5001","Gakki");
			managers.get(0).addFollower("5002","Yui");

			//加入一个默认广告牌
			AdTerminal.getInstance().addAdDisplayBoard(new AdDisplayBoard());

			return shellInstance;
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		String input;
		Scanner scanner = new Scanner(System.in);

		MainCashierShell shell = MainCashierShell.getInstance();

		System.out.println("\n-------- Welcome, input commands to do something --------------");
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
				"showAd [type] [brand] [slogan]		| 所有广告牌上显示广告 Type:PicAd/VideoAd\n" +
				"---------------------------------------------------------------------------");
		while (scanner.hasNext()) {
			input = scanner.nextLine();
			String[] orders = input.split(" ");

			System.out.println("输入指令:" + orders[0]);

			//add rm 结帐单场景，测试Command设计模式，同时测试Adapter设计模式
			if(orders[0].equals("add")) {
				codeScanner.scan("BarCode",orders[1]); //Adapter
				OrderListManager.add(orders[1]);
				continue;
			}

			if (orders[0].equals("rm")) {
				OrderListManager.rm(orders[1]);
				continue;
			}

			//redo undo 结帐单场景，测试Memento设计模式
			if (orders[0].equals("redo")) {
				OrderListManager.redo();
				continue;
			}

			// 测试MVC设计模式
			if (orders[0].equals("undo")) {
				OrderListManager.undo();
				OrderListManager.updateView();
				continue;
			}

			//打印商品信息，测试Visitor设计模式
			if (orders[0].equals("print")) {
				OrderListManager.updateView();
				continue;
			}

			if (orders[0].equals("mkNew")) {
				//单例模式
				orderListManager.mkNew();
				continue;
			}

			//mkCoffee 测试涉及Command | Abstract Factory | Chain of Responsibility |
			//   Template Method | Factory Method | Iterator 设计模式
			if (orders[0].equals("mkCoffee")) {
				//转换传入各个参数
				MakeCoffeeCommand mkCoffeeCommand = new MakeCoffeeCommand(OrderListManager.getListController(),
						Integer.parseInt(orders[1]), Integer.parseInt(orders[2]), Integer.parseInt(orders[3]));
				OrderListManager.runCommand(mkCoffeeCommand);
				continue;
			}

			//mkMtea 测试涉及 Interpreter | Builder | Chain of Responsibility | Template Method | Iterator 设计模式
			if (orders[0].equals("mkMTea")) {
				System.out.println("正在添加一杯奶茶，请输入制作参数命令");
				System.out.println(" 0.RedMilkTea 1.GreenMilkTea\n" +
						" 0.cool 1.normal 2.hot\n" +
						" 0.freesugar 1.halfsugar 2.regularsugar\n" +
						" 0.coconut 1.pudding 2.bean");
				MakeMilkTeaCommand mkTeaCommand = new MakeMilkTeaCommand(OrderListManager.getListController(),scanner.nextLine());
				OrderListManager.runCommand(mkTeaCommand);
				continue;
			}

			//mkIceCream 测试 Bridge 设计模式
			if (orders[0].equals("mkIceCream")) {
				if(orders[1].equals("0")) {
					IceCream iceCream = new IceCream("Vanilla",orders[2]);
					HomemadeOrderListItem item = new HomemadeOrderListItem("100002", 1, iceCream);
					OrderListManager.getListController().addItem(item);
				} else if(orders[1].equals("1")){
					IceCream iceCream = new IceCream("Chocolate",orders[2]);
					HomemadeOrderListItem item = new HomemadeOrderListItem("100003", 1, iceCream);
					OrderListManager.getListController().addItem(item);
				}
				continue;
			}

			//员工管理，测试 Composite 设计模式
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

			//广告牌管理场景 测试 Mediator 设计模式
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

			//商品Logo 测试 Flyweight 设计模式
			if(orders[0].equals("printLogo")) {
				FlyweightPattern flyweightPattern=new FlyweightPattern();
				flyweightPattern.showFlyweight(orders[1]);
				continue;
			}
		}
	}

}
