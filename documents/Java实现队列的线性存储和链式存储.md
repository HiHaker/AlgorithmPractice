### 队列（Queue）

​	队列是一种具有一定操作约束的线性表，它的插入和删除操作都只能在一端进行，数据插入叫做**入队**，数据删除称为**出队**，它是一种典型的先进先出（FIFO）的结构。

### 抽象数据类型描述

​	数据对象集：一个有0个或多个元素的线性表。

​	操作集：`Item` 代表数据元素类型

- `boolean isEmpty()` 判断队列是否为空
- `int length()` 返回队列的大小
- `void addQueue(Item item)` 入队
- `Item deleteQueue()` 出队

### 队列的顺序存储

​	采用声明的固定大小的数组来存储数据，因为队列是先进先出的，入队和出队只在一端进行，所以会发生数组内部空间无法得到充分利用的情况（随着入队和出队操作不断进行，队首指针和队尾指针会不停的往后移动，这样数组前面的空间就无法得到充分的利用），所以需要用到循环队列，而采取循环的关键就是取余数。对队首指针和队尾指针加一后需要进行取余数的操作，这样指针可以实现循环。完整代码如下：

```java
public class ArrayQueue<Item> {
    private Item[] data;
    private int first;
    private int last;
    private int size;

    public ArrayQueue(int size){
        data = (Item[]) new Object[size];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int length(){
        return size;
    }

    public void addQueue(Item item){
        // 先判断是否满了
        if (size == data.length){
            System.out.println("队列已满!");
            return;
        } else{
            last = (last + 1)%data.length;
            data[last] = item;
            size = size+1;
        }
    }

    public Item deleteQueue(){
        // 先判断是否为空
        if (size == 0){
            System.out.println("队列为空!");
            return null;
        } else{
            first = (first + 1)%data.length;
            size = size-1;
            return data[first];
        }
    }

    public void printData(){
        int current = (first+1)%data.length;
        for (int i=1; i<=size; i++){
            System.out.print(data[current] + " ");
            current = (current+1)%data.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> testQ = new ArrayQueue<>(5);
        testQ.addQueue(1);
        testQ.addQueue(2);
        testQ.deleteQueue();
        testQ.addQueue(3);
        testQ.deleteQueue();
        testQ.addQueue(4);
        testQ.addQueue(5);
        testQ.printData();
    }
}
```



### 队列的链式存储

​	由于链表的头部和尾部对于插入和删除操作的适应性不同（链表头部插入和删除均很方便，链表尾部插入方便，无法删除），所以队首（出队操作）要设在链表的链表头部，队尾（入队操作）设在链表尾部，然后还需要注意的地方就是，在第一次入队时需要把队首指针也指向第一个结点，在删除了最后一个元素时需要把队尾指针指向`null`，完整代码如下：

```java
public class Queue<Item> implements Iterable<Item>{
    private Node first; // 指向最早添加的结点
    private Node last; //指向最近添加的结点
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null; // 或者N等于0
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        // 刚开始时，如果队列为空，要把first也指向第一个元素
        if (isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
        N = N + 1;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        // 如果删除之后为空，也要把last指向null
        if (isEmpty()){
            last = null;
        }
        N = N - 1;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current!= null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {}
    }
}
```