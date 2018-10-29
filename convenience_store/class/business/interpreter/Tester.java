package business.interpreter;

import java.math.BigDecimal;

/**
 * Interpreter Tester
 * @author 马一帆
 * @version 0.1
 */
public class Tester {
    public static void main(String[] args) {
        Context context = new Context();
        Variable a = new Variable();
        Variable b = new Variable();
        Variable h = a;
        context.addValue(a, BigDecimal.valueOf(14));
        context.addValue(b, BigDecimal.valueOf(100));

        Expression expression = new Mul(new Add(h,b),b);
        int[] s = {1,2,2};
        System.out.println(MilkTeaPriceGetter.getPrice(1,1,1,s));
    }
}
