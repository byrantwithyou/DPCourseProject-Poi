package ChainofResponsibility;
import tools.Scanner;

/**
 * @author Zhou Hongyu
 */
public class ScannerHandler extends Handler {
    /**
     * @param s 将handler与一个Scanner绑定
     */
    public ScannerHandler(Scanner s){
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
            handle();
            request.handled();
            return true;
        }
        else{
            return false;
        }
    }
}
