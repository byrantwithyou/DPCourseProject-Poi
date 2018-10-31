package sampleApp;
//设计模式:Interpreter 
import java.math.BigDecimal;

import system.iterpreter.Add;
import system.iterpreter.Context;
import system.iterpreter.Expression;
import system.iterpreter.MilkTeaPriceGetter;
import system.iterpreter.Mul;
import system.iterpreter.Variable;

/**
 * Interpreter Tester
 * @author 马一帆
 * @version 0.1
 */
public class OrderMilkTea {
    public static void main(String[] args) {
        Context context = new Context();
        Variable a = new Variable();
        Variable b = new Variable();
        Variable h = a;
        context.addValue(a, BigDecimal.valueOf(14));
        context.addValue(b, BigDecimal.valueOf(100));

        @SuppressWarnings("unused")
		Expression expression = new Mul(new Add(h,b),b);
        int[] s = {1,2,2};
        System.out.println(MilkTeaPriceGetter.getPrice(1,1,1,s));
    }
}
