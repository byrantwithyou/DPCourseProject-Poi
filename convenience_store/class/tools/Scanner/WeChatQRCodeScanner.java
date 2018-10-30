package tools.Scanner;

/**
 * @author Hou Xianda
 */
public abstract class WeChatQRCodeScanner implements QRCodeScanner {
    /**
     * 
     * @param scanObject 传入扫描对象
     */
    public abstract void scanWeChatQRCode(Object scanObject);
    public abstract void scanAliPayQRCode(Object scanObject);
}
