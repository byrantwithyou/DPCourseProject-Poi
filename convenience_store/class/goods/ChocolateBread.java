package goods;

import visitor.Visitor;

import java.math.BigDecimal;


/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的chocobread类
 * 包含id为000001，价格为15.2
 */
public class ChocolateBread extends BaseGoods {

    public ChocolateBread() {
        this.setId("000001");
        this.setUitPrice(new BigDecimal(15.2));
    }

    public void accept(Visitor visitor) {
        visitor.visitChocolateBread(this);
    }

}
