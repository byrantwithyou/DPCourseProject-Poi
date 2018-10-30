package Requests;

/**
 * @author 马一帆
 * @version 0.1
 */
public class ScanRequest extends Request{
    public ScanRequest(RequestCategory category) {
        super(category);
    }

    public ScanRequest(RequestCategory category, String scanType, Object scanObject) {
        super(category);
        this.RequestBag = new Input(scanType, scanObject);
    }

    public class Input {
        public String scanType;
        public Object scanObject;

        Input(String scanType, Object scanObject) {
            this.scanType = scanType;
            this.scanObject = scanObject;
        }
    }
}

