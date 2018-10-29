package business.interpreter;

import java.math.BigDecimal;

/**
 * @author 马一帆
 * @version 0.1
 */
public class Variable implements Expression{

    @Override
    public BigDecimal interpret(Context context) {
        return context.LookupValue(this);
    }
}
