package goods.stock;

import java.math.BigDecimal;

import goods.Goods;


/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的chocobread类
 * 包含id为000001，价格为15.2
 */
public class ChocolateBread extends Goods {

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

    public ChocolateBread() {
        this.setId("000001");
        this.setUitPrice(new BigDecimal(15.2));
        this.setCompany("河北旺哥食品有限公司");
        this.setName("唇动巧克力味蛋糕");
        this.setOriginPlace("河北省沧州市青县经济开发区");
    }


    public void accept(Visitor visitor) {
        visitor.visitChocolateBread(this);
    }

}
