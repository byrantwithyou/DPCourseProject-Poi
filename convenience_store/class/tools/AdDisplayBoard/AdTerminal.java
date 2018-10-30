package tools.AdDisplayBoard;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hou Xianda
 */
public class AdTerminal {
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
     *
     * @param ad 要展示的广告
     */
    public void showAd(Advertisement ad) {
        if (adDisplayBoards.isEmpty()) {
            System.out.println("No available Display Board");
        }

        for (AdDisplayBoard adDisplayBoard : adDisplayBoards) {
            adDisplayBoard.showAd(this, ad);
        }
    }

    /**
     *
     * @param adDisplayBoard 向链表中添加广告展示板
     */
    public void addAdDisplayBoard(AdDisplayBoard adDisplayBoard) {
        adDisplayBoards.add(adDisplayBoard);
    }

    /**
     *
     * @param index 移除链表中的某个广告展示板
     */
    public void removeDisplayBoard(int index) {
        adDisplayBoards.remove(index);
    }
}

