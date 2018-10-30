package flyweight;

public class QuickNoodleFlyweight extends Flyweight {
    private String string;
    public QuickNoodleFlyweight(String str){
        string=str;
    }

    public void operation()
    {
        System.out.print("                                        \n" +
                "       ..::7rr71vr77r::v...7ii.         \n" +
                "      qds:.....i7ii:Y::is7i:irY72i      \n" +
                "      .dQPLii:.:. .i::irirrrruKgq.      \n" +
                "       .uBBBBBBQSEBBQdgPPZRbRquv        \n" +
                "       .:i5BQBBBBBBBBBBBBBMBQLii        \n" +
                "       .JL::BIubBQBBBBBBQvvZBEXv        \n" +
                "        KPPXPB1E2gBUiU2BQgggS2gY        \n" +
                "        jQQBBBi1:.j:.Lr7Kvi2:rQ:        \n" +
                "        .BQMQBI1qrII XI:jr:juPE         \n" +
                "         QBrPQBgBXUKMvrE7:P.:gb         \n" +
                "         7Z:.QBgQg..:rrr:jYvi:i         \n" +
                "         iv . IBY.vUIPd572ZED.          \n" +
                "         .1XL.LR KEvYjjqgbPg5L          \n" +
                "          YBZsBM :BgI7i:IJvsi.          \n" +
                "           ..iQB: iPd2vvjYi.         \n");
    }
}
