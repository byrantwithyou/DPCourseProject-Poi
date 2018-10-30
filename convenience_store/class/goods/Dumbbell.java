package goods;

import visitor.Visitor;

import java.math.BigDecimal;

/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的dumbbell类
 * 包含id为000003，价格为195
 */
public class Dumbbell extends BaseGoods{
    public Dumbbell() {
        this.setId("000003");
        this.setUitPrice(new BigDecimal(195));
    }

    public void accept(Visitor visitor) {
        visitor.visitDumbbell(this);
    }
}
