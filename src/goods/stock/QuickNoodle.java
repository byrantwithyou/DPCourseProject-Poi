package goods.stock;


import java.math.BigDecimal;

import goods.Goods;

/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的chocobread类
 * 包含id为000004，价格为5.6
 */

public class QuickNoodle extends Goods {
    private String originPlace;
    private String name;
    private String company;

    public void setOriginPlace(String string){this.originPlace=string;}
    public void setName(String string){this.name=string;}
    public void setCompany(String string){this.company=string;}


    public String getOriginPlace() {
        return originPlace;
    }
    public String getName(){return  name;}
    public String getCompany(){return company;}

    public QuickNoodle() {
        this.setId("000004");
        this.setUitPrice(new BigDecimal(5.6));
        this.setCompany("昆山统一企业食品有限公司");
        this.setName("统一生活面 汤达人日式豚骨拉面125g");
        this.setOriginPlace("江苏省昆山经济技术开发区青阳南路301号");
    }

    public void accept(Visitor visitor) {
        visitor.visitQuickNoodle(this);
    }
}
