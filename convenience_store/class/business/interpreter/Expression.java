package business.interpreter;

import java.math.BigDecimal;

/**
 * 抽象表达式
 * @author 马一帆
 * @version 0.1
 */
public interface Expression {
    BigDecimal interpret(Context context);
}
