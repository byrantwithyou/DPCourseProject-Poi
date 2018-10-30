package visitor;

import goods.*;

/**
 * @author 田括铜
 * @version 1.0
 * 该类具体实现了Visitor类
 * 通过调用visit(String id)函数来进行访问，
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
    QuickNoodle quickNoodle;
    QiaoLeZi qiaoLeZi;
//构造函数
   public ConcreteVisitor()
   {
    chocolateBreadtemp=new ChocolateBread();
    javaCoffee=new JavaCoffee();
    dumbbell=new Dumbbell();
    qiaoLeZi=new QiaoLeZi();
    quickNoodle=new QuickNoodle();
   }
   //对chocobread的visit
    public void visitChocolateBread(ChocolateBread chocolateBread)
    { System.out.print("商品名称："+chocolateBread.getName()
            +"\n商品单价："+chocolateBread.getUitPrice()
            +"\n商品公司： " +chocolateBread.getCompany()
            +"\n商家地址： "+chocolateBread.getOriginPlace()); }
    //对Javacoffee的visit
    public void visitJavaCoffee(JavaCoffee javaCoffee)
    { System.out.print("商品名称："+javaCoffee.getName()
            +"\n商品单价："+javaCoffee.getUitPrice()
            +"\n商品公司： " +javaCoffee.getCompany()
            +"\n商家地址： "+javaCoffee.getOriginPlace()); }
    //对dumbbell的visit
    public void visitDumbbell(Dumbbell dumbbell)
    {System.out.print("商品名称："+dumbbell.getName()
            +"\n商品单价："+dumbbell.getUitPrice()+
            "\n商品公司： " +dumbbell.getCompany()
            +"\n商家地址： "+dumbbell.getOriginPlace());}
    //对Qiaolezi的visit
    public void visitQiaoLeZi(QiaoLeZi qiaoLeZi)
    {System.out.print("商品名称："+qiaoLeZi.getName()
            +"\n商品单价："+qiaoLeZi.getUitPrice()+
            "\n商品公司： " +qiaoLeZi.getCompany()
            +"\n商家地址： "+qiaoLeZi.getOriginPlace());}
    //对QuickNoodle的visit
    public void visitQuickNoodle(QuickNoodle quickNoodle)
    {System.out.print("商品名称："+quickNoodle.getName()
            +"\n商品单价："+quickNoodle.getUitPrice()
            +"\n商品公司： " +quickNoodle.getCompany()
            +"\n商家地址： "+quickNoodle.getOriginPlace());}



    /**
     * 进行对商品的访问
     * @param id  输入商品id
     * 01：巧克力面包 02：雀巢咖啡 03：哑铃 04：方便面 05：巧乐兹
     * 输出：依次打印商品名称，价格，公司，产地，每项之间换行，最后无换行
     */
    public void visit(String id)
    {
        /*Iterator iterator=collection.iterator();
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
        else if(id=="000004")
        {
            quickNoodle.accept(this);
        }
        else if(id=="000005")
        {
            qiaoLeZi.accept(this);
        }
    }

}
