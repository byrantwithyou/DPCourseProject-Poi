package flyweight;

import java.util.Hashtable;

/**
 * @author 田括铜
 * @version  1.0
 * 实现工厂方法类，用哈希表来储存对象，有对象就返回，没有就新建
 */
public class FlyweightFactory {
    private Hashtable flyweights=new Hashtable();
    public FlyweightFactory(){}

    /**
     * @param obj 传入想要打印的物体名称
     * @return  返回想要打印的物体
     */
    public Flyweight getFlyWeight(Object obj){
        Flyweight flyweight=(Flyweight)flyweights.get(obj);
        if(flyweight==null){
            if((String)obj=="JavaCoffee") {
                flyweight = new JavaCoffeeFlyweight((String) obj);
                flyweights.put(obj, flyweight);
            }
            else if((String)obj=="ChocolateBread"){
                flyweight=new ChocolaeBreadFlyweight((String)obj);
                flyweights.put(obj,flyweight);
            }
            else if((String)obj=="Dumbbell"){
                flyweight=new DumbbellFlyweight((String)obj);
                flyweights.put(obj,flyweight);
            }
        }
        return  flyweight;
    }
    public  int getFlyweightSize(){
        return  flyweights.size();
    }
}