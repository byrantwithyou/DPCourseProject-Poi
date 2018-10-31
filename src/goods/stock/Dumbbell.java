package goods.stock;

import java.math.BigDecimal;

import goods.Goods;

/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的dumbbell类
 * 包含id为000003，价格为195
 */
public class Dumbbell extends Goods{

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

    public Dumbbell() {

        this.setId("000003");
        this.setUitPrice(new BigDecimal(195));
        this.setCompany(" Decathlon/迪卡侬");
        this.setName("迪卡侬20公斤电镀哑铃男士健身家用");
        this.setOriginPlace("上海市宝山区陆翔路111号正大缤纷城1F 61736960");
    }

    public void accept(Visitor visitor) {
        visitor.visitDumbbell(this);
    }
}
