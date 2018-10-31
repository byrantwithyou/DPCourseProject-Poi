package tools.scanner;

/**
 * @author Hou Xianda
 */


public interface QRCodeScanner {
    /**
     * 
     * @param scanObject 传入扫描对象
     */
	void scanWeChatQRCode(Object scanObject);
    void scanAliPayQRCode(Object scanObject);
}
