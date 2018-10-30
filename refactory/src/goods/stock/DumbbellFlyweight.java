package goods.stock;

/**
 * @author 田括铜
 * @version 1.0
 * 打印dumbbell的基本元素类，operation函数进行打印
 */
public class DumbbellFlyweight extends Flyweight {
    private String string;
    public DumbbellFlyweight(String str){
        setString(str);
    }

    public void operation()
    {
        System.out.print("           :::             i:.          \n" +
                "         :ir:7.           irii:.        \n" +
                "        .QdBv::           r:KQXg        \n" +
                "    is7:MBBQDBJ:iiiiiiiii.qBQQBB2ivj:   \n" +
                "    JBb1IbYvqBEsvJLJsJYJ7JQBJLsPJ5dBi   \n" +
                "        :2r..X:           vU..rU.       \n" +
                "        .BBIrL:           r7v2BB        \n" +
                "         75QBP            .QBB1:        \n" +
                "           7bi             Lb:         \n");
    }

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
