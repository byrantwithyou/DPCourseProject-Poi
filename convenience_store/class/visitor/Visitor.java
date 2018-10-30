package visitor;

import goods.*;

/**
 *  @author 田括铜
 *  @version 1.0
 * 该类为Visitor的接口，目前包括6个函数
 * 由ConcreteVisitor具体实现
 */

public interface Visitor {

    public void visitChocolateBread(ChocolateBread chocolateBread);
    public void visitJavaCoffee(JavaCoffee javaCoffee);
    public void visitDumbbell(Dumbbell dumbbell);
    public void visitQiaoLeZi(QiaoLeZi qiaoLeZi);
    public void visitQuickNoodle(QuickNoodle quickNoodle);

    public void visit(String string);

}
