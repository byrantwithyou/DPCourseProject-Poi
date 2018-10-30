package useTools;

import Requests.Request;
import Requests.RequestCategory;
import tools.IceCreamMaker;

public class IceCreamMakerHandler extends Handler {
    /**
     * @param i 将handler与一个IceCreanMaker绑定
     */
    public IceCreamMakerHandler(IceCreamMaker i) {
        super(i);
    }

    /**
     * @param request 请求
     * @return 返回是否相应了请求
     * 只有当请求类型相符合且机器空闲才进行处理
     */
    @Override
    public Boolean handleReq(Request request) {
        if(request.getCategory() == RequestCategory.makeIceCream && !isBusy()){
            handle(request.RequestBag, request.returnObj);
            request.handled();
            return true;
        }
        else{
            return false;
        }
    }
}
