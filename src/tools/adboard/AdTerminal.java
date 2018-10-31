package tools.adboard;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hou Xianda
 */
public class AdTerminal {
    /**
     * 融合Singleton设计模式
     */
    public static AdTerminal instance = new AdTerminal();

    private AdTerminal() {
        adDisplayBoards = new LinkedList<>();
        System.out.println(this.getClass().getName() + " :: " + "AdTerminal()" + " : " + "Constructor called");
    }

    public static AdTerminal getInstance() {
        System.out.println("tools.adboard.AdTerminal" + " :: " + "getInstance()" + " : " + "Method called: " + "Return the instance of AdTerminal");
        return instance;
    }

    private String terminalId;

    private List<AdDisplayBoard> adDisplayBoards;

    public AdTerminal(String terminalId) {
        this.terminalId = terminalId;
        adDisplayBoards = new LinkedList<>();
        System.out.println(this.getClass().getName() + " :: " + "AdTerminal()" + " : " + "Constructor called");
    }

    public String getTerminalId() {
        return terminalId;
    }

    /**
     * 在所有展示板上显示广告
     * @param ad 需要显示的广告类
     */
    @SuppressWarnings("static-access")
	public void showAd(Advertisement ad) {
        System.out.println(this.getClass().getName() + " :: " + "showAd()" + " : " + "Method called: " + "Display the ad on all DisplayBoards");
        if (adDisplayBoards.isEmpty()) {
            System.out.println("No available Display Board");
            return;
        }

        for (AdDisplayBoard adDisplayBoard : adDisplayBoards) {
            adDisplayBoard.showAd(this, ad);
        }
    }

    /**
     * 添加一个展示板
     * @param adDisplayBoard 需要添加的广告板
     */
    public void addAdDisplayBoard(AdDisplayBoard adDisplayBoard) {
        System.out.println(this.getClass().getName() + " :: " + "addDisplayBoard()" + " : " + "Method called: " + "Add a DisplayBoard");
        adDisplayBoards.add(adDisplayBoard);
    }

    /**
     * 移除某一个展示板
     * @param index 需要移除的展示板序号
     */
    public void removeDisplayBoard(int index) {
        System.out.println(this.getClass().getName() + " :: " + "removeDisplayBoard()" + " : " + "Method called: " + "Remove a DisplayBoard");
        adDisplayBoards.remove(index);
    }

    public int getBoardsAmount() {
        System.out.println(this.getClass().getName() + " :: " + "getBoardsAmount()" + " : " + "Method called: " + "Get the amount of DisplayBoards");
        return adDisplayBoards.size();
    }
}

