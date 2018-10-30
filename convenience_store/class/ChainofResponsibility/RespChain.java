package ChainofResponsibility;
import Iterator.myLinkedList;
import Iterator.myIterator;
import tools.*;
import tools.Scanner.RealScanner;
import tools.Scanner.ScannerAdapter;

/**
 * @author Zhou Hongyu
 */
public class RespChain {
    private myLinkedList chain;
    private myIterator iterator;

    /**
     * 添加扫码机（下面五个函数相似）
     * @param num 扫码机数量
     */
    public void addScanner(int num){
        for(int i=0; i<num; ++i){
            chain.add(new ScannerHandler(new RealScanner()));
        }
    }

    public void addMicro(int num){
        for(int i=0; i<num; ++i){
            chain.add(new MicrowaveOvenHandler(new MicrowaveOven()));
        }
    }

    public void addMilkTeaMaker(int num){
        for(int i=0; i<num; ++i){
            chain.add(new MilkTeaMakerHandler(new MilkTeaMaker()));
        }
    }

    public void addIceMaker(int num){
        for(int i=0; i<num; ++i){
            chain.add(new IceCreamMakerHandler(new IceCreamMaker()));
        }
    }

    public void addCoffeeMaker(int num){
        for(int i=0; i<num; ++i){
            chain.add(new CoffeeMakerHandler(new CoffeeMaker()));
        }
    }

    /**
     * 输入扫码机，微波炉，奶茶机，冰激淋机，咖啡机数量初始化责任链
     * @param numofScanner 扫码机数量
     * @param numofMicro 微波炉数量
     * @param numofMilkTeaMaker 奶茶机数量
     * @param numofIceMaker 冰淇淋机数量
     * @param numofCoffeeMaker 咖啡机数量
     */
    public RespChain(int numofScanner, int numofMicro, int numofMilkTeaMaker, int numofIceMaker, int numofCoffeeMaker){
        chain = new myLinkedList();
        iterator = chain.createIterator();
        addScanner(numofScanner);
        addMicro(numofMicro);
        addMilkTeaMaker(numofMilkTeaMaker);
        addIceMaker(numofIceMaker);
        addCoffeeMaker(numofCoffeeMaker);
    }

    /**
     * handler.handleReq()函数为template设计模式
     * 责任链接收请求
     * @param r 请求
     * @return 返回请求是否被处理
     */
    public boolean receiveReq(Request r){
        while(true) {
            Handler handler = (Handler) iterator.Current();
            if (handler.handleReq(r)) {
                iterator.reset();
                return true;
            } else if (iterator.hasNext()) {
                iterator.Next();
            } else {
                iterator.reset();
                break;
            }
        }
        return false;
    }
}
