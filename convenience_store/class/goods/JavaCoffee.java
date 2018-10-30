package goods;

import visitor.Visitor;

import java.math.BigDecimal;

/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的JavaCoffee类
 * 包含id为000002，价格为30
 */
public class JavaCoffee extends BaseGoods {
    public JavaCoffee() {
        this.setId("000002");
        this.setUitPrice(new BigDecimal(30));
    }

    public void accept(Visitor visitor) {
        visitor.visitJavaCoffee(this);
    }
}
