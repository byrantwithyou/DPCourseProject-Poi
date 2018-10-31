package tools.scanner;

/**
 * @author Hou Xianda
 */
public abstract class WeChatQRCodeScanner implements QRCodeScanner {

    public WeChatQRCodeScanner() {
        System.out.println(this.getClass().getName() + " :: " + "WeChatQRCodeScanner()" + " : " + "Constructor called");
    }

    /**
     * 
     * @param scanObject 传入扫描对象
     */
    public abstract void scanWeChatQRCode(Object scanObject);
    public abstract void scanAliPayQRCode(Object scanObject);
}
