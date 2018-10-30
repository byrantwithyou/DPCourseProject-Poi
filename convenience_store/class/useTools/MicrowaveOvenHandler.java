package useTools;
import Requests.Request;
import Requests.RequestCategory;
import tools.MicrowaveOven;

/**
 * @author Zhou Hongyu
 */
public class MicrowaveOvenHandler extends Handler {
    /**
     * @param m 将handler与一个MicrowaveOven绑定
     */
    public MicrowaveOvenHandler(MicrowaveOven m){
        super(m);
    }

    /**
     * @param request 请求
     * @return 返回是否相应了请求
     * 只有当请求类型相符合且机器空闲才进行处理
     */
    @Override
    public Boolean handleReq(Request request) {
        if(request.getCategory() == RequestCategory.heatBox && !isBusy()){
            handle(request.RequestBag);
            request.handled();
            return true;
        }
        else{
            return false;
        }
    }
}
