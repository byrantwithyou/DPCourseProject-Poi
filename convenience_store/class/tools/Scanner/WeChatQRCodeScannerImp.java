package tools.Scanner;

/**
 * @author Hou Xianda
 */
public class WeChatQRCodeScannerImp extends WeChatQRCodeScanner {
    /**
     *
     * @param scanObject 传入扫描对象
     */
    public void scanWeChatQRCode(Object scanObject) {
        System.out.println("--------------------------------------------");
        System.out.println("Scan Succeeded!");
        System.out.println("Scan Object Type : WeChat QR Code");
        System.out.println("--------------------------------------------\n");
    }

    public void scanAliPayQRCode(Object scanObject) {
        //Do nothing.
    }
}
