package system.iterpreter;

import java.math.BigDecimal;

/**
 * 乘法 - Expression
 * @author 马一帆
 * @version 0.1
 */
public class Mul implements Expression{
    private Expression left,right;

    public Mul(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public BigDecimal interpret(Context context) {
        return left.interpret(context).multiply(right.interpret(context));
    }
}
