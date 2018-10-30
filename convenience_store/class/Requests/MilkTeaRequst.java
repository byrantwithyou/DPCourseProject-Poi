package Requests;

import java.util.ArrayList;

/**
 * @author 马一帆
 * @version 0.1
 */
public class MilkTeaRequst extends Request {
    /**
     * @param category 类型RequestCategory, 用于初始化成员变量Category, 成员变量IsHandled初始化为false
     */
    public MilkTeaRequst(RequestCategory category) {
        super(category);
    }

    public MilkTeaRequst(RequestCategory category, int type, int temperature, int sweetness, double price, ArrayList<Integer> topping) {
        super(category);
        this.RequestBag=new Req(type,temperature,sweetness,price,topping);
    }

    public class Req{
        public int type;
        public int temperature;
        public int sweetness;
        public double price;
        public ArrayList<Integer> topping;
        Req(int type,int temperature,int sweetness,double price,ArrayList<Integer> topping){
            this.type=type;
            this.temperature=temperature;
            this.sweetness=sweetness;
            this.price=price;
            this.topping=topping;
        }
    }
}