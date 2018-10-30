package tools;

import goods.MilkTea;

import java.util.ArrayList;

/**
 * 抽象的奶茶工厂类
 * @author  liuchang
 * @version 0.1
 */
abstract class MilkTeaBuilder{
    protected MilkTea milkTea;

    public MilkTea getMilkTea(){return milkTea;}
    public void createNewMilkTea(){milkTea=new MilkTea();}

    public abstract void buildName();
    public abstract void buildTemprature(int i);
    public abstract void buildSweetness(int i);
    public abstract void bulidTopping(ArrayList<Integer> i);
    public abstract void buildPrice(double i);
}