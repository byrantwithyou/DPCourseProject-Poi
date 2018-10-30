package Requests;

/**
 * @author Zhou Hongyu
 */
public class Request {
    private RequestCategory Category;
    private Boolean IsHandled;
    public Object RequestBag;

    /**
     * @param category 类型RequestCategory, 用于初始化成员变量Category, 成员变量IsHandled初始化为false
     */
    public Request(RequestCategory category){
        Category = category;
        IsHandled = false;
    }

    /**
     * Handler处理请求完成后调用，更改成员变量IsHandled为True
     */
    void handled(){
        IsHandled = true;
    }

    /**
     * @return 返回请求种类
     */
    public RequestCategory getCategory(){
        return Category;
    }
}
