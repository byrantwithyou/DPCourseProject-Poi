package sampleApp;


import system.command.AddCommand;
import system.command.CancelableCommand;
import system.command.Command;
import system.command.RemoveCommand;
import system.command.UncancelCommand;


import java.util.ArrayList;
import java.util.Scanner;

import business.orderlist.OrderController;
import business.orderlist.OrderList;
import business.orderlist.OrderListMemento;
import business.orderlist.OrderView;

/**
 * Test command memento
 * @author 马一帆
 * @version 0.1
 */
public class OrderListManager {
    private static final int cancelableTypes = 2;
    private static final int uncancelTypes = 1;
    private static final int LIST_LENGTH = 20;
    private static ArrayList<CancelableCommand> commandsList;
    private static ArrayList<OrderListMemento> mementoList;
    private static OrderListManager managerInstance = null;
    private static OrderList currentList; //结帐单存储结构
    private static OrderController listController;
    private static OrderView orderView;

    static int numCommands; //当前列表内command的数量
    static int highWater; //当前状态表内数量

    private OrderListManager() {
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
        System.out.println(OrderListManager.getInstance().getClass().getSimpleName() + "(" + currentList.getVisitorId()
                + ")： undo method is called :" + " try to undo last command");

        if(numCommands == 0) {
            System.out.println("--- 已至可恢复末尾 ---\n");
            return;
        }

        currentList.reinstateMemento(mementoList.get(numCommands - 1));
        numCommands--;
    }

    public static void redo() {
        System.out.println(OrderListManager.getInstance().getClass().getSimpleName() + "(" + currentList.getVisitorId()
                + ")： redo method is called :" + " try to redo last command");

        if(numCommands > highWater || commandsList.size() == 0) {
            System.out.println("--- 已至可重做末尾 ---\n");
            return;
        }
        System.out.println(OrderListManager.getInstance().getClass().getName() + " redo last command");
        commandsList.get(numCommands).execute();
        numCommands++;
    }

    public static OrderListManager getInstance() {
        if(managerInstance != null) {
            return managerInstance;
        } else {
            System.out.println("OrderListManager" + "("
                    + ")： Constructor called :" + " single instance is created");
            managerInstance = new OrderListManager();
            commandsList = new ArrayList<>(LIST_LENGTH);
            mementoList = new ArrayList<>(LIST_LENGTH);
            currentList = new OrderList(0);
            orderView = new OrderView();
            listController = new OrderController(currentList,orderView);

            numCommands = highWater = 0;
            return managerInstance;
        }
    }

    public static ArrayList<CancelableCommand> getCommandsList() {
        return commandsList;
    }

    public static OrderList getCurrentList() {
        return currentList;
    }

    public static OrderController getListController() {
        return listController;
    }

    public static OrderView getOrderView() {
        return orderView;
    }

    public static void add(String id) throws CloneNotSupportedException {
        AddCommand addCommand = new AddCommand(id);
        addCommand.setReceiver(listController);
        OrderListManager.runCommand(addCommand);
    }

    public static void mkNew() {
        OrderListManager.currentList = new OrderList(0);
        OrderListManager.orderView = new OrderView();
        OrderListManager.listController = new OrderController(OrderListManager.currentList, OrderListManager.orderView);
    }

    public static void updateView() {
        OrderListManager.listController.updateView();
    }

    public static void rm(String goalID) throws CloneNotSupportedException {
        RemoveCommand removeCommand = new RemoveCommand(goalID);
        removeCommand.setReceiver(listController);
        OrderListManager.runCommand(removeCommand);
    }
    //Commands与Memento单元测试
    public static void main(String[] args) throws CloneNotSupportedException {
        String input;
        Scanner scanner = new Scanner(System.in);
        OrderListManager shell = OrderListManager.getInstance();

        System.out.println("**** Order List  | Test Command & Memento ****");
        System.out.println("add [id]		| 加入商品 id:000001~000005\n" +
                "rm [id]		| 从结帐单移除商品\n" +
                "undo		| 撤销\n" +
                "redo		| 重做\n" +
                "print		| 打印当前结帐单所有内容\n" +
                "mkNew		| 新的顾客\n");
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            String[] orders = input.split(" ");

            System.out.println("Your input:" + orders[0]);

            if(orders[0].equals("add")) {
                OrderListManager.add(orders[1]);
                continue;
            }

            if (orders[0].equals("rm")) {
                OrderListManager.rm(orders[1]);
                continue;
            }

            if (orders[0].equals("redo")) {
                OrderListManager.redo();
                continue;
            }

            if (orders[0].equals("undo")) {
                OrderListManager.undo();
                OrderListManager.updateView();
                continue;
            }

            if (orders[0].equals("print")) {
                OrderListManager.updateView();
                continue;
            }

            if (orders[0].equals("mkNew")) {
                OrderListManager.mkNew();
                continue;
            }
        }
    }

}
