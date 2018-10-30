package tools.maker;

import system.Request;
import system.RequestCategory;
import system.Handler;

/**
 * @author Zhou Hongyu
 */
public class CoffeeMakerHandler extends Handler {
    /**
     * @param c 将handler与一个CoffeeMaker绑定
     */
    public CoffeeMakerHandler(CoffeeMaker c) {
        super(c);
    }

    /**
     * @param request 请求
     * @return 返回是否相应了请求
     * 只有当请求类型相符合且机器空闲才进行处理
     */
    @Override
    public Boolean handleReq(Request request) {
        if(request.getCategory() == RequestCategory.makeCoffe && !isBusy()){
            handle(request.RequestBag, request.returnObj);
            request.handled();
            return true;
        }
        else{
            return false;
        }
    }
}
