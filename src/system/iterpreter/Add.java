package system.iterpreter;

import java.math.BigDecimal;

/**
 * 加号 - Expression
 * @author 马一帆
 * @version 0.1
 */
public class Add implements Expression{
    private Expression left,right;

    public Add(Expression left, Expression right) {
        System.out.println(this.getClass().getSimpleName()
                + ": ()" + "interpret method is called: interpreting..");
        this.left = left;
        this.right = right;
    }

    @Override
    public BigDecimal interpret(Context context) {
        return left.interpret(context).add(right.interpret(context));
    }
}
