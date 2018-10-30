package tools;
import goods.Coffee;

/**
 * 抽象的咖啡工厂类
 * @author 刘畅
 * @version 0.1
 */
abstract  class CoffeeBuilder {
    Coffee coffee;
    public void makeCoffee(){coffee=new Coffee();}
    public abstract void setName();
    public abstract void setTemperature(int i);
    public abstract void setSweetness(int i);
    public abstract void setPrice(double i);
    public Coffee getCoffee(){return coffee;}
}

/**
 * 摩卡咖啡工厂类，用于获取此类咖啡的实体
 * @author 刘畅
 * @version 0.1
 */
class MochaCoffeeBuilder extends CoffeeBuilder{

    public void setName(){coffee.setName("MochaCoffee");}

    public void setTemperature(int i){
        if(i==0)coffee.setTemperature("Cool");
        else if(i==1)coffee.setTemperature("Normal");
        else if(i==2)coffee.setTemperature("Hot");
    }

    public void setSweetness(int i){
        if(i==0)coffee.setSweetness("FreeSugar");
        else if(i==1)coffee.setSweetness("HalfSugar");
        else if(i==2)coffee.setSweetness("RegularSugar");
    }

    public void setPrice(double i){
        coffee.setPrice(i);
    }
}

/**
 * 美式咖啡工厂类，用于获取此类咖啡实体
 * @author 刘畅
 * @version 0.1
 */
class AmericanCoffeeBuilder extends CoffeeBuilder{

    public void setName(){coffee.setName("AmericanCoffee");}

    public void setTemperature(int i){
        if(i==0)coffee.setTemperature("Cool");
        else if(i==1)coffee.setTemperature("Normal");
        else if(i==2)coffee.setTemperature("Hot");
    }

    public void setSweetness(int i){
        if(i==0)coffee.setSweetness("FreeSugar");
        else if(i==1)coffee.setSweetness("HalfSugar");
        else if(i==2)coffee.setSweetness("RegularSugar");
    }

    public void setPrice(double i){
        coffee.setPrice(i);
    }
}

/**
 * 卡布奇诺咖啡工厂类，用于获取此类咖啡实体
 * @author 刘畅
 * @version 0.1
 */
class GappuccinoCoffeeBuilder extends CoffeeBuilder{
    public void setName(){coffee.setName("GappuccinoCoffee");}

    public void setTemperature(int i){
        if(i==0)coffee.setTemperature("Cool");
        else if(i==1)coffee.setTemperature("Normal");
        else if(i==2)coffee.setTemperature("Hot");
    }

    public void setSweetness(int i){
        if(i==0)coffee.setSweetness("FreeSugar");
        else if(i==1)coffee.setSweetness("HalfSugar");
        else if(i==2)coffee.setSweetness("RegularSugar");
    }

    public void setPrice(double i){
        coffee.setPrice(i);
    }
}
