package tools.scanner;

/**
 * @author Hou Xianda
 */
public class WeChatQRCodeScannerImp extends WeChatQRCodeScanner {
    /**
     * 
     * @param scanObject 传入扫描对象
     */
    public void scanWeChatQRCode(Object scanObject) {
        /*
        System.out.println("Scan Succeeded!");
        System.out.println("Scan Object Type : WeChat QR Code");
        System.out.println("The Content of the scanObject: " + scanObject.toString());
        */
        System.out.println(this.getClass().getName() + " :: " + "scanWeChatQRCode()" + " : " + "Scan WeChat QR Code method called");
    }

    public void scanAliPayQRCode(Object scanObject) {
        //Do nothing.
    }
}
