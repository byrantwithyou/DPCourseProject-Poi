package visitor;

import goods.*;

/**
 *  @author 田括铜
 *  @version 1.0
 * 该类为Visitor的接口，目前包括4个函数
 * 由ConcreteVisitor具体实现
 */

public interface Visitor {

    public void visitChocolateBread(ChocolateBread chocolateBread);
    public void visitJavaCoffee(JavaCoffee javaCoffee);
    public void visitDumbbell(Dumbbell dumbbell);

    public void visit(String string);

}
