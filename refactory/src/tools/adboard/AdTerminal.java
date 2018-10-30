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
    }

    public static AdTerminal getInstance() {
        return instance;
    }

    private String terminalId;

    private List<AdDisplayBoard> adDisplayBoards;

    public AdTerminal(String terminalId) {
        this.terminalId = terminalId;
        adDisplayBoards = new LinkedList<>();
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
        adDisplayBoards.add(adDisplayBoard);
    }

    /**
     * 移除某一个展示板
     * @param index 需要移除的展示板序号
     */
    public void removeDisplayBoard(int index) {
        adDisplayBoards.remove(index);
    }

    public int getBoardsAmount() { return adDisplayBoards.size(); }
}

