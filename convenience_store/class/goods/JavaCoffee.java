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

    public JavaCoffee() {

        this.setId("000002");
        this.setUitPrice(new BigDecimal(30));
        this.setCompany("Nestle/雀巢");
        this.setOriginPlace(" 巴西进口");
        this.setName("雀巢咖啡醇品速溶原味黑咖啡粉纯咖啡");
    }

    public void accept(Visitor visitor) {
        visitor.visitJavaCoffee(this);
    }
}
