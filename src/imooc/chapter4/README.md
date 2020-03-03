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