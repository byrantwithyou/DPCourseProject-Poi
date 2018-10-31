package goods.stock;

/**
 * @author 田括铜
 * @version 1.0
 * 打印chocolatebread的基本元素类，operation函数进行打印
 */
public class ChocolateBreadFlyweight extends Flyweight {
    private String string;
    public ChocolateBreadFlyweight(String str){
        setString(str);
    }

    public void operation()
    {
        System.out.print("                                        \n" +
                "              .:i.                      \n" +
                "           ivUISIXIur:                  \n" +
                "       .uSdXqI5u2JISPPqSUr.             \n" +
                "      XQZEbbXSUUj1Ljs1uU1XXX2sr:        \n" +
                "     SBgDERbDPqKKIS1JLJvjIbSEBBBB:      \n" +
                "     BBgdMgMQgQgZDPqS5sYPZBBBQZug.      \n" +
                "     .gBQDdEDdQMBMDgMSURBgPU7i  Pv      \n" +
                "       7SgDQgQqPZDgRgBQEPP:. ..UJg.     \n" +
                "           .7SbUqqRdPgE2.XKZivBBB       \n" +
                "              .rYPdSXgM7  :i.gMKr       \n" +
                "                 .7sQQYj77RRgr          \n" +
                "                   .:YRBBBr             \n" +
                "                      .:               \n");
    }

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
