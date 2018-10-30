package visitor;

import goods.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author 田括铜
 * @version 1.0
 * 该类为具体实现Visitor类
 * 通过调用visitor（string）函数来进行访问
 */

public class ConcreteVisitor implements Visitor {

    //Collection collection;
   /* Vector<BaseGoods> vector;
    public ConcreteVisitor()
    {
        vector.add(new ChocolateBread());
    }*/
    ChocolateBread chocolateBreadtemp;
    JavaCoffee javaCoffee;
    Dumbbell dumbbell;
//构造函数
   public ConcreteVisitor()
   {
    chocolateBreadtemp=new ChocolateBread();
    javaCoffee=new JavaCoffee();
    dumbbell=new Dumbbell();
   }
   //对chocobread的visit
    public void visitChocolateBread(ChocolateBread chocolateBread)
    { System.out.print(chocolateBread.getUitPrice()); }
    //对Javacoffee的visit
    public void visitJavaCoffee(JavaCoffee javaCoffee)
    { System.out.print(javaCoffee.getUitPrice()); }
    //对dumbbell的visit
    public void visitDumbbell(Dumbbell dumbbell)
    {System.out.print(dumbbell.getUitPrice());}


    /**
     * 进行对商品的访问，目前只提供价格信息
     * @param id  输入商品id
     * 输出：打印商品价格（不带换行）
     */
    public void visit(String id)
    {
        /*useTools.Iterator iterator=collection.iterator();
        do{
            if(collection[iterator])
        } while (iterator.hasNext());*/
        if(id=="000001")
        {
            chocolateBreadtemp.accept(this);
        }
        else if(id=="000002")
        {
            javaCoffee.accept(this);
        }
        else if(id=="000003")
        {
            dumbbell.accept(this);
        }
    }

}
