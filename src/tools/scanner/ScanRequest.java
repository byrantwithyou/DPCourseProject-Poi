package tools.scanner;

import system.Request;
import system.RequestCategory;

/**
 * @author 马一帆
 * @version 0.1
 */
public class ScanRequest extends Request{
    public ScanRequest(RequestCategory category, Object returnObj) {
        super(category, returnObj);
    }

    public ScanRequest(RequestCategory category, Object returnObj, String scanType, Object scanObject) {
        super(category, returnObj);
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

