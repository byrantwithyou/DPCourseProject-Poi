package system.iterator;

import system.Handler;

/**
 * @author Zhou Hongyu
 */
public class ListIterator implements myIterator {
    private myLinkedList linkedList;
    private Handler cur;

    /**
     * @param list 传递容器
     */
    ListIterator(myLinkedList list){
        linkedList = list;
        cur = list.listhead;
    }

    @Override
    public Object First() {
        return linkedList.listhead;
    }

    @Override
    public Object Next() {
        if(cur == null){
            cur = linkedList.listhead;
        }
        if(cur == null){
            System.out.println("The list is empty");
            System.exit(-1);
        }
        cur = cur.next;
        return cur;
    }

    @Override
    public Object Current() {
        if(cur == null){
            cur = linkedList.listhead;
        }
        return cur;
    }

    @Override
    public void reset() {
        cur = linkedList.listhead;
    }

    @Override
    public boolean hasNext() {
        if(cur == null){
            cur = linkedList.listhead;
        }
        return cur!=null && cur.next != null;
    }

    @Override
    public void remove() {
        if(cur == null){
            cur = linkedList.listhead;
        }
        if(cur == null){
            System.out.println("The list is empty");
            System.exit(-1);
        }
        Handler h = linkedList.listhead;
        if(h == cur){
            h = cur.next;
            if (cur.next != null) {
                Handler tmp = cur;
                cur = cur.next;
                tmp.next = null;
            } else {
                linkedList.listhead = null;
                cur = null;
            }
        }
        else {
            while (h.next != null) {
                if (h.next == cur) {
                    h.next = cur.next;
                } else {
                    h = h.next;
                }
            }
            if (cur.next != null) {
                Handler tmp = cur;
                cur = cur.next;
                tmp.next = null;
            } else {
                Handler tmp = cur;
                cur = h;
                tmp.next = null;
            }
        }
    }
}
