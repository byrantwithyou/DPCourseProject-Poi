package tools;

import goods.Coffee;
import goods.MilkTea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public  class Main{
    public  static void main(String[] args)throws IOException {
        MilkTeaMaker maker=new MilkTeaMaker();
        ArrayList<Integer> topping=new ArrayList<Integer>();
        topping.add(1);
        topping.add(2);
        topping.add(0);
        MilkTea test=maker.getMilkTea(0,2,1,4.5,topping);
        System.out.println(test.getName()+test.getSweetness()+test.getTemperature()+test.getTopping()+test.getPrice());
        CoffeeMaker maker1=new CoffeeMaker() ;
        Coffee t=maker1.getCoffee(2,2,2,1.28);
        System.out.println(t.getName()+t.getSweetness()+t.getTemperature()+t.getPrice());
    }
}