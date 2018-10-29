package Iterator;

/**
 * @author Zhou Hongyu
 */
public interface myIterator {
    /**
     * @return 返回容器内第一个对象
     */
    public Object First();

    /**
     * @return 返回下一个对象
     */
    public Object Next();

    /**
     * @return 返回迭代器当前位置的对象
     */
    public Object Current();

    /**
     * 重制迭代器
     */
    public void reset();

    /**
     * @return 当前位置是否有下一个对象
     */
    public boolean hasNext();

    /**
     * 移除当前迭代器位置上的对象
     * 如果后面有对象，迭代器移动到下一个
     * 如果后面没有对象而前面有对象，迭代器移动到前一个
     * 否则迭代器变空
     */
    public void remove();
}
