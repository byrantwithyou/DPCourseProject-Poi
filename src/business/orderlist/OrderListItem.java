package business.orderlist;

import goods.stock.ConcreteVisitor;

/**
 * 结帐单项目
 * @author 马一帆
 * @version 0.1
 */
public class OrderListItem implements Cloneable{
    private static ConcreteVisitor goodsInfoGetter = new ConcreteVisitor();
    private String goodsID;
    private int amount = 1;

    public OrderListItem(String goodsId,int amount) {
        this.goodsID = goodsId;
        this.amount = amount;
    }

    public void printOut() {
        //此处对于商品信息的读取应考虑结合visitor
//        System.out.println(this.getClass().getName() + ": " + goodsID + " " + amount);
        //以下尝试使用visitor
        goodsInfoGetter.visit(goodsID);
        System.out.println();
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount() {
        amount++;
    }

    @Override
    protected OrderListItem clone() throws CloneNotSupportedException {
        return new OrderListItem(goodsID,amount);
    }
}
