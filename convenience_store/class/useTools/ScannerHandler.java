package useTools;
import Requests.Request;
import Requests.RequestCategory;
import tools.Scanner.RealScanner;

/**
 * @author Zhou Hongyu
 */
public class ScannerHandler extends Handler {
    /**
     * @param s 将handler与一个Scanner绑定
     */
    public ScannerHandler(RealScanner s){
        super(s);
    }

    /**
     * @param request 请求类型
     * @return 返回是否相应了请求
     * 只有当请求类型相符合且机器空闲才进行处理
     */
    @Override
    public Boolean handleReq(Request request) {
        if(request.getCategory() == RequestCategory.scanCode && !isBusy()){
            handle(request.RequestBag);
            request.handled();
            return true;
        }
        else{
            return false;
        }
    }
}
