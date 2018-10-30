package tools.Scanner;

/**
 * @author Hou Xianda
 */
interface QRCodeScanner {
    /**
     * 
     * @param scanObject 传入扫描对象
     */
	void scanWeChatQRCode(Object scanObject);
    void scanAliPayQRCode(Object scanObject);
}
