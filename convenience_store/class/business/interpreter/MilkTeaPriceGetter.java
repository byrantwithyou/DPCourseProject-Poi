package business.interpreter;

import java.math.BigDecimal;

/**
 * 传入表达式，获取应付价格
 *
 * @author 马一帆
 * @version 0.1
 */
public class MilkTeaPriceGetter {
    public static BigDecimal getPrice(int type, int heat, int sugar, int[] adds) {
        Context context = new Context();
        System.out.print(MilkTeaPriceGetter.class + " calculating ");
        System.out.printf("%d %d %d %d %d %d\n",type,heat,sugar,adds[0],adds[1],adds[2]);
//        //以下是标准的意大利面条式代码 ┭┮﹏┭┮
//        //三种奶茶
//        Variable pearlMilkTea = new Variable();
//        Variable taroMilkTea = new Variable();
//        Variable strawberryMilkTea = new Variable();
//
//        context.addValue(pearlMilkTea,BigDecimal.valueOf(15));
//        context.addValue(taroMilkTea,BigDecimal.valueOf(17));
//        context.addValue(strawberryMilkTea,BigDecimal.valueOf(15.5));
//
//        //三种冷热模式
//        Variable cool = new Variable();
//        Variable normal = new Variable();
//        Variable hot = new Variable();
//
//        context.addValue(cool,BigDecimal.valueOf(1));
//        context.addValue(normal,BigDecimal.valueOf(1));
//        context.addValue(hot,BigDecimal.valueOf(1.05));
//
//        //三种甜度
//
//        Variable halfsugar = new Variable();
//        Variable normalsugar = new Variable();
//        Variable freesugar = new Variable();
//
//        context.addValue(halfsugar,BigDecimal.valueOf(1));
//        context.addValue(freesugar,BigDecimal.valueOf(1));
//        context.addValue(normalsugar,BigDecimal.valueOf(1));
        Variable[] teaVars = new Variable[3];
        Variable[] heatVars = new Variable[3];
        Variable[] sugarVars = new Variable[3];
        Variable[] addVars = new Variable[3];

        for(int i=0;i<3;i++) {
            teaVars[i] = new Variable();
            heatVars[i] = new Variable();
            sugarVars[i] = new Variable();
            addVars[i] = new Variable();
        }
        context.addValue(teaVars[0], BigDecimal.valueOf(15));
        context.addValue(teaVars[1], BigDecimal.valueOf(17));
        context.addValue(teaVars[2], BigDecimal.valueOf(15.5));

        for (int i = 0; i < 3; i++) {
            context.addValue(heatVars[i], BigDecimal.valueOf(1.0));
            context.addValue(sugarVars[i], BigDecimal.valueOf(1.0));
            if (adds[i] > 0) {
                context.addValue(addVars[i], BigDecimal.valueOf(2));
            } else {
                context.addValue(addVars[i],BigDecimal.valueOf(0));
            }
        }

        context.addValue(heatVars[2], BigDecimal.valueOf(1.05));

        Variable selectType = teaVars[type];
        Variable selectHeat = heatVars[heat];
        Variable selectSugar = sugarVars[sugar];

        Expression expression = new Add(new Add(new Add(new Mul(new Mul(selectType,selectHeat),selectSugar),
                addVars[0]),addVars[1]),addVars[2]);

        return expression.interpret(context);
    }
}
