package tools.Scanner;

import tools.Tools;

/**
 * @author Hou Xianda
 */
public class RealScanner extends Tools implements Scanner {
    private ScannerAdapter scannerAdapter;

    /**
     * 
     * @param scanType 传入扫描对象的类型（如"WeChatQRCode"）
     * @param scanObject 传入扫描对象
     */
    @Override
    public void scan(String scanType, Object scanObject) {
        setIsbusy(true);
        if (scanType.equalsIgnoreCase("BarCode")) {
            System.out.println("--------------------------------------------");
            System.out.println("Scan Succeeded!");
            System.out.println("Scan Object Type : Bar Code");
            System.out.println("--------------------------------------------\n");
        } else if (scanType.equalsIgnoreCase("WeChatQRCode") || scanType.equalsIgnoreCase("AliPayQRCode")) {
            scannerAdapter = new ScannerAdapter(scanType);
            scannerAdapter.scan(scanType,scanObject);
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("Scan Failed");
            System.out.println("Unable to recognize the scanObject: [" + scanType + "]\nPlease check if the type of scanObject is supported.");
            System.out.println("--------------------------------------------");
        }
        setIsbusy(false);
    }
}
