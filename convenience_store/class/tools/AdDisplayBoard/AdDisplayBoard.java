package tools.AdDisplayBoard;

import java.util.Date;

/**
 * @author Hou Xianda
 */
public class AdDisplayBoard {

    /**
     *
     * @param adTerminal 上传广告的终端
     * @param ad 要展示的广告
     */
    public static void showAd(AdTerminal adTerminal, Advertisement ad) {
        System.out.println("The Current time is: " + new Date().toString());
        System.out.println(adTerminal.getTerminalId());
        ad.show();
    }
}
