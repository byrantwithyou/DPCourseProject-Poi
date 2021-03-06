package tools.scanner;

/**
 * @author Hou Xianda
 */
public class ScannerAdapter implements Scanner {
	private QRCodeScanner qRCodeScanner;

	/**
	 * 
	 * @param scanType 传入扫描对象的类型，以初始化ScannerAdapter
	 */
	public ScannerAdapter(String scanType) {
		System.out.println(this.getClass().getName() + " :: " + "ScannerAdapter()" + " : " + "Constructor called");
		if (scanType.equalsIgnoreCase("WeChatQRCode")) {
			qRCodeScanner = new WeChatQRCodeScannerImp();
		} else if (scanType.equalsIgnoreCase("AliPayQRCode")) {
			qRCodeScanner = new AliPayQRCodeScannerImp();
		}
	}

	/**
	 * 
	 * @param scanType 传入扫描对象的类型
	 * @param scanObject 传入扫描对象
	 */
	public void scan(String scanType, Object scanObject) {
		System.out.println(this.getClass().getName() + " :: " + "scan()" + " : " + "Scan method called");
		if (scanType.equalsIgnoreCase("WeChatQRCode")) {
			qRCodeScanner.scanWeChatQRCode(scanObject);
		} else if (scanType.equalsIgnoreCase("AliPayQRCode")) {
			qRCodeScanner.scanAliPayQRCode(scanObject);
		}
	}
	
}
