package sampleApp;

import visitor.ConcreteVisitor;

public class VisitorSample {
    public static void main(String[] args)
    {
        ConcreteVisitor concreteVisitor=new ConcreteVisitor();
        System.out.println("打印五种商品信息：");
        concreteVisitor.visit("000001");
        System.out.println("\n");
        concreteVisitor.visit("000002");
        System.out.println("\n");
        concreteVisitor.visit("000003");
        System.out.println("\n");
        concreteVisitor.visit("000004");
        System.out.println("\n");
        concreteVisitor.visit("000005");
    }
}
