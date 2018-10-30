package Requests;

/**
 * @author 马一帆
 * @version 0.1
 */
public class CoffeeRequst extends Request {
    /**
     * @param category 类型RequestCategory, 用于初始化成员变量Category, 成员变量IsHandled初始化为false
     */
    public CoffeeRequst(RequestCategory category) {
        super(category);
    }

    public CoffeeRequst(RequestCategory category,int type,int temperature,int sweetness,double price) {
        super(category);
        this.RequestBag=new Req(type,temperature,sweetness,price);
    }

    public class Req{
        public int type;
        public int temperature;
        public int sweetness;
        public double price;
        Req(int type,int temperature,int sweetness,double price){
            this.type=type;
            this.temperature=temperature;
            this.sweetness=sweetness;
            this.price=price;
        }
    }
}
