### 前言

之前学习过的数据结构都是线性数据结构，学习了包括 <u>动态数组、栈、队列</u>这三种结构，但它们底层上还是依托的静态数组，靠`resize`方法来解决固定的容量问题。

接下来要学习的线性结构是链表，这是一个真正意义上的动态的数据结构，也是最简单的动态数据结构，通过学习，我们可以更深入的理解引用（或者指针），更深入的理解递归，链表也是辅助组成其他数据结构的重要部分。

### 链表 Linked List

数据存储在“节点”（Node）中：

```java
class Node{
    E e;
    Node next;
}
```

<u>优点</u>：真正的动态，不需要处理固定容量的问题。

<u>缺点</u>：丧失了随机访问的能力，因为不像静态数组开辟的是一块连续的空间，可以直接根据偏移量找到元素，链表需要通过引用或者说指针才能找到元素。

#### 数组和链表的对比

数组最好用于索引有语义的情况。最大优点：支持快速查询。

链表不适合用于索引有语义的情况。最大优点：动态。

**链表的实现（头结点的技术）**

```java
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
```

**链表实现栈**

```java
// 链表实现栈
package imooc.chapter4;

import imooc.chapter3.ArrayStack;
import imooc.chapter3.Stack;

import java.util.Random;

/**
 * Created on 2020/1/31 0031
 * BY Jianlong
 * 使用链表实现栈
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:0 top ");
        res.append(linkedList.toString());
        return res.toString();
    }

    // 计算运行opCount次入栈出栈操作所耗费时间
    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i=0; i<opCount; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i=0; i<opCount; i++){
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayStack<Integer> aStack = new ArrayStack<>();
        double time1 = testStack(aStack, opCount);

        LinkedListStack<Integer> lStack = new LinkedListStack<>();
        double time2 = testStack(lStack, opCount);

        System.out.println("time1 = " + time1 + ", time2 = " + time2);
    }
}
```

**链表实现队列**

```java
// 链表实现队列
package imooc.chapter4;

import imooc.chapter3.Queue;

/**
 * Created on 2020/1/31 0031
 * BY Jianlong
 */
public class LinkedListQueue<E> implements Queue<E> {
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

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // 如果队列为空
        if (isEmpty()){
            tail = new Node(e, null);
            head = tail;
        } else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null){
            tail = null;
        }

        size --;

        return delNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = head;
        res.append("Queue front ");
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        res.append(" tail");

        return res.toString();
    }
}
```