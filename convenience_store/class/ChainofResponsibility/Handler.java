package ChainofResponsibility;
import tools.*;

/**
 * @author Zhou Hongyu
 */
public abstract class Handler {
    private Tools tool;
    public Handler next;

    /**
     * @param t 初始化handler管理的工具, next初始化为空
     */
    Handler(Tools t){
        tool = t;
        next = null;
    }

    /**
     * @param request 请求
     * @return 返回是否相应了请求
     */
    public abstract Boolean handleReq(Request request);

    /**
     *
     * @return 返回这个handler管理的工具是否忙碌
     */
    Boolean isBusy(){
        return tool.isBusy();
    }

    /**
     * 处理请求，工具做相应的操作
     */
    void handle(){
        tool.work();
    }
}
