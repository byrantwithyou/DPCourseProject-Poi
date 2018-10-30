package tools;

import java.util.ArrayList;

/**
 * 香芋奶茶工厂类用于产生相应的奶茶实体
 * @author liuchang
 * @version 0.1
 */
public class TaroMilkTeaBuilder extends MilkTeaBuilder {
    public void buildName(){milkTea.setName("TaroMilkTea");}
    public void buildTemprature(int i){
        if(i==0) milkTea.setTemperature("Cool");
        else if(i==1)milkTea.setTemperature("Normal");
        else if(i==2)milkTea.setTemperature("Hot");
    }
    public void buildSweetness(int i){
        if(i==0) milkTea.setSweetness("FreeSugar");
        else if(i==1) milkTea.setSweetness("HalfSugar");
        else if(i==2)milkTea.setSweetness("RegularSugar");
    }
    public void bulidTopping(ArrayList<Integer> i){
        String coconut="Coconut";
        String pudding="Pudding";
        String bean="Bean";
        if(i.contains(0))milkTea.setTopping(coconut);
        if(i.contains(1))milkTea.setTopping(pudding);
        if(i.contains(2))milkTea.setTopping(bean);
    }
    public void buildPrice(double i){
        milkTea.setPrice(i);
    }
}
