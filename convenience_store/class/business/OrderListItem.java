package business;

/**
 * 结帐单项目
 * @author 马一帆
 * @version 0.1
 */
public class OrderListItem implements Cloneable{
    private String goodsID;
    private int amount = 1;

    public OrderListItem(String goodsId,int amount) {
        this.goodsID = goodsId;
        this.amount = amount;
    }

    public void printOut() {
        //此处对于商品信息的读取应考虑结合visitor
        System.out.println(this.getClass().getName() + ": " + goodsID + " " + amount);
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
