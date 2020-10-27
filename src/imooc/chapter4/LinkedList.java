package imooc.chapter4;

/**
 * Created on 2020/1/17 0017
 * BY Jianlong
 */
public class LinkedList<E> {
    /**
     * 屏蔽内部实现细节，用户不需要知道底层实现
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            e = null;
            next = null;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

//    private Node head;
    private Node dummyHead; // 虚拟头结点
    private int size;

    public LinkedList(){
//        head = null;
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中元素个数
    public int getSize(){
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 在链表中间添加元素
    // 关键就是需要找到要添加的节点的位置的前一个节点
    // 在链表的操作中，顺序很重要
    // 在链表的index(0-based)位置添加新的元素e
    // 这个在实际中不是一个常用操作，练习用:)
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, illegal index.");
        }
//
//        if (index == 0){
//            addFirst(e);
//        } else{
//            Node prev = head;
//            // 要找到插入位置的前一个节点
//            for (int i=0; i<index - 1; i++){
//                prev = prev.next;
//            }
//
//            prev.next = new Node(e, prev.next);
//            size ++;
//        }
        Node prev = dummyHead;
        // 要找到插入位置的前一个节点
        for (int i=0; i<index; i++){
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size ++;

    }

    // 向链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);
//        size ++;
        add(0, e);
    }

    // 链表的末尾添加元素
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 在上面的操作中，向链表中间添加元素时对于在索引为0和索引为其他的值处理时有区别
     * 这是因为这个操作是要找到待添加位置的前一个节点，而链表头前没有节点
     * 下面有一种常用的技巧可以把队链表头的操作和其他操作统一起来：
     * 为链表设立虚拟的头结点 - dummyhead
     * 这样，就可以实现代码的复用
     */

    // 删除对应的索引的元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, illegal index.");
        }

        Node prev = dummyHead;

        for (int i=0; i<index; i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        // 将此节点与链表脱离关系
        retNode.next = null;
        size --;

        return retNode.e;
    }

    // 从链表中删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除第一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习使用:)
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed, illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i=0; i<index; i++){

            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    // 修改
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed, illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i=0; i<index; i++){
            cur = cur.next;
        }

        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

}
