package flyweight;

public class QiaoLeZiFlyweight extends Flyweight {
    private String string;
    public QiaoLeZiFlyweight(String str){ string=str; }

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
