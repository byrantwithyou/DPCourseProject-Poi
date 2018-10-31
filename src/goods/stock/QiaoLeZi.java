package goods.stock;


import java.math.BigDecimal;

import goods.Goods;

/**
 * @author 田括铜
 * @version 1.0
 * 基于Basegoods建立的Qiaolezi类
 * 包含id为000005，价格为3
 */

public class QiaoLeZi extends Goods{

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

        public QiaoLeZi() {
            this.setId("000005");
            this.setUitPrice(new BigDecimal(3));
            this.setCompany("天津伊利康业冷冻食品有限公司");
            this.setName("伊利巧乐兹雪糕巧脆棒");
            this.setOriginPlace("天津市津南经济开发区(双桥河)宝源路3");
        }

        public void accept(Visitor visitor) {
            visitor.visitQiaoLeZi(this);
        }

}
