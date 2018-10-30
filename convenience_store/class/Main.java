import useTools.*;
import Requests.Request;
import Requests.RequestCategory;

public class Main {
    /**
     * iterator, chain of responsibility测试
     */
    public static void main(String[] args){
//        myLinkedList l = new myLinkedList();
//        l.add(new CoffeeMakerHandler(new CoffeeMaker()));
//        l.add(new CoffeeMakerHandler(new CoffeeMaker()));
//        l.add(new CoffeeMakerHandler(new CoffeeMaker()));
//        l.add(new CoffeeMakerHandler(new CoffeeMaker()));
//        myIterator iterator = l.createIterator();
//        System.out.println(iterator.Current().toString());
//        iterator.Next();
//        System.out.println(iterator.Current().toString());
//        iterator.Next();
//        System.out.println(iterator.Current().toString());
//        iterator.Next();
//        System.out.println(iterator.Current().toString());
//        iterator.remove();
//        System.out.println(iterator.Current().toString());
//        iterator.remove();
//        System.out.println(iterator.Current().toString());
//        iterator.remove();
//        System.out.println(iterator.Current().toString());
//        iterator.remove();
//        System.out.println(iterator.Current());
//        l.add(new MilkTeaMakerHandler(new MilkTeaMaker()));
//        System.out.println(iterator.Current().toString());
//        l.add(new MilkTeaMakerHandler(new MilkTeaMaker()));
//        iterator.Next();
//        System.out.println(iterator.Current().toString());
//        l.add(new ScannerHandler(new Scanner() {
//            @Override
//            public void work() {
//                System.out.println("fds");
//            }
//        }));
//        iterator.Next();
//        System.out.println(iterator.Current().toString());
//        System.out.println(iterator.First());
        RespChain respChain = new RespChain(2,4,1,1,1);
//        System.out.println(respChain.receiveReq(new Request(RequestCategory.heatBox)));
    }
}
