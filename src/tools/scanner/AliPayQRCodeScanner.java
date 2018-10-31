package tools.scanner;


/**
 * @author Hou Xianda
 */


public abstract class AliPayQRCodeScanner implements QRCodeScanner{

    public AliPayQRCodeScanner() {
        System.out.println(this.getClass().getName() + " :: " + "AliPayQRCodeScanner()" + " : " + "Constructor called");
    }

    /**
     * @param scanObject 传入扫描对象
     */
    public abstract void scanAliPayQRCode(Object scanObject);
    public abstract void scanWeChatQRCode(Object scanObject);
}
