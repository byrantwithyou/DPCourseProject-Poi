package flyweight;

/**
 * @author 田括铜
 * @version 1.0
 * 打印JavaCoffeeFlyweight的基本元素类，，operation函数进行打印
 */
public class JavaCoffeeFlyweight extends Flyweight {
    private String string;
    public JavaCoffeeFlyweight(String str){
        string=str;
    }

    public void operation()
    {
        System.out.print("                     .                  \n" +
                "                     X                  \n" +
                "                    D2                  \n" +
                "                  jBr :.                \n" +
                "                7Bj 27.                 \n" +
                "               .B. BY                   \n" +
                "                g7 RB.                  \n" +
                "                 i  B5   .              \n" +
                "            7Qs:  . i.:  .Bu            \n" +
                "            .i2r::...i.  .BJ            \n" +
                "              vLririrv: :r              \n" +
                "               dJLvY1v                  \n" +
                "          rBJ.  :irii.   .:             \n" +
                "           i.:ii::.::ir7rr:             \n");
    }
}
