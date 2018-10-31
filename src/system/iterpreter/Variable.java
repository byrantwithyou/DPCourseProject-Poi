package system.iterpreter;

import java.math.BigDecimal;

/**
 * @author 马一帆
 * @version 0.1
 */
public class Variable implements Expression{

    @Override
    public BigDecimal interpret(Context context) {
        System.out.println(this.getClass().getSimpleName()
                + ": ()" + "interpret method is called: interpreting..");
        return context.LookupValue(this);
    }
}
