package Iterator;

import ChainofResponsibility.Handler;

/**
 * @author Zhou Hongyu
 */
public class myLinkedList implements Aggregate {
    public Handler listhead;

    /**
     * 创建空链表
     */
    public myLinkedList(){
        listhead = null;
    }

    /**
     * @param head 传递链表首对象
     */
    public myLinkedList(Handler head){
        listhead = head;
    }

    /**
     * @param handler 传递添加到链表末尾到对象
     */
    public void add(Handler handler){
        if(listhead == null){
            listhead = handler;
        }
        else {
            Handler cur = listhead;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = handler;
        }
    }

    /**
     *创建迭代器
     * @return 传递自身为参数
     */
    @Override
    public myIterator createIterator() {
        return new ListIterator(this);
    }
}
