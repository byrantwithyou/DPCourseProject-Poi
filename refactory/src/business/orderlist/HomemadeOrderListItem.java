package business.orderlist;

import goods.homemade.HomemadeGoods;

/**
 * @author 马一帆
 * @version 0.1
 */
public class HomemadeOrderListItem extends OrderListItem {
    HomemadeGoods goodsInstance;

    @Override
    public void printOut() {
        //System.out.println("手制奶茶" + goodsInstance.getId() + "  price:" + goodsInstance.getUitPrice());
        goodsInstance.printOut();
    }

    public HomemadeOrderListItem(String goodsId, int amount, HomemadeGoods goodsInstance) {
        super(goodsId, amount);
        this.goodsInstance = goodsInstance;
    }

    @Override
    protected OrderListItem clone() throws CloneNotSupportedException {
        return new HomemadeOrderListItem(this.getGoodsID(),this.getAmount(),goodsInstance);
    }
}
