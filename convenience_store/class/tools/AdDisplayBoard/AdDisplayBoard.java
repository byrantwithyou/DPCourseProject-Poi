package tools.AdDisplayBoard;

import java.util.Date;

/**
 * @author Hou Xianda
 */
public class AdDisplayBoard {
    /**
     * 通过静态方法直接将接收到的广告打印出来
     * @param adTerminal 发送广告的终端
     * @param ad 需要展示的广告
     */
    public static void showAd(AdTerminal adTerminal, Advertisement ad) {
        System.out.println("The Current time is: " + new Date().toString());
        ad.show();
    }
}
