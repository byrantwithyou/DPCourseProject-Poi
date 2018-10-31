package tools.scanner;

import system.ScanRequest;
import tools.Tools;

/**
 * @author Hou Xianda
 */
public class RealScanner extends Tools implements Scanner {

    public RealScanner() {
        super();
        System.out.println(this.getClass().getName() + " :: " + "RealScanner()" + " : " + "Constructor called");
    }

    private ScannerAdapter scannerAdapter;

    /**
     * 
     * @param scanType 传入扫描对象的类型（如"WeChatQRCode"）
     * @param scanObject 传入扫描对象
     */
    @Override
    public void scan(String scanType, Object scanObject) {
        setIsbusy(true);
        System.out.println(this.getClass().getName() + " :: " + "scan()" + " : " + "Scan method called");
        if (scanType.equalsIgnoreCase("BarCode")) {
            /*
            System.out.println("Scan Succeeded!");
            System.out.println("Scan Object Type : Bar Code");
            System.out.println("The Content of the scanObject: " + scanObject.toString());
            */
            System.out.println(this.getClass().getName() + " :: " + "scan()" + " : " + "Scan Bar Code method called");
        } else if (scanType.equalsIgnoreCase("WeChatQRCode") || scanType.equalsIgnoreCase("AliPayQRCode")) {
            scannerAdapter = new ScannerAdapter(scanType);
            scannerAdapter.scan(scanType,scanObject);
        } else {
            /*
            System.out.println("Scan Failed");
            System.out.println("Unable to recognize the scanObject: [" + scanType + "]\nPlease check if the type of scanObject is supported.");
            */
            System.out.println(this.getClass().getName() + " :: " + "scan()" + " : " + "Invalid scanType");
        }
        setIsbusy(false);
    }

    /**
     *
     * @param requestBag 传入执行work()所需的数据包
     */
    @Override
    public void work(Object requestBag, Object returnObj) {
        System.out.println(this.getClass().getName() + " : " + "work()" + " : " + "Work method called");
        if (!requestBag.getClass().getName().equalsIgnoreCase("Requests.ScanRequest")) {
            System.out.println("Invalid Request Type! Must be 'ScanRequest'");
            return;
        }
        scan(((ScanRequest.Input)requestBag).scanType, ((ScanRequest.Input)requestBag).scanObject);
    }
}
