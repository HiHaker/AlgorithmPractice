### 栈（Stack）

​	栈是具有一定操作约束的线性表，它只在一端（栈顶）做插入和删除操作，它是典型的后进先出的一种数据结构，特别的，插入数据称为**入栈（Push）**，删除数据称为**出栈（Pop）**。

### 抽象数据类型描述

​	数据对象集：一个有0个或多个元素的线性表。

​	操作集：Item 代表数据元素类型

- `int length()` 返回栈的长度（所包含的元素的个数）。
- `boolean isEmpty()` 栈是否为空。
- `void push(Item item)` 入栈。
- `Item pop()` 出栈

### 栈的顺序存储

​	在类的内部使用数组来存储元素，数组的大小会根据需要动态的变化，因为有一个`resize()`方法，使用`N`来表示栈顶的上面一个位置，入栈时，先将元素放入`data[N]`，`N`再进行加一的操作；反之，出栈时，先将N减一，取出元素，再置此时`data[N]`的值为null，避免对象游离。为了能够使栈可以遍历，实现了`Iterable`接口，完整代码如下：

```java
public class ArrayStack<Item> implements Iterable<Item> {

    private Item[] data = (Item[]) new Object[1]; // 栈里的数据
    private int N = 0; // 栈的元素个数

    public boolean isEmpty(){
        return N==0;
    }

    public int length(){
        return N;
    }

    public void resize(int len){
        Item[] temp = (Item[]) new Object[len];
        for (int i=0; i<N; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public void push(Item item){
        if (N == data.length){
            this.resize(2* data.length);
        }
        data[N++] = item;
    }

    public Item pop(){
        Item item = data[--N];
        data[N] = null; // 避免对象游离
        if (N>0 && N==data.length/4){
            this.resize(data.length/2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // 内部类
    public class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        public boolean hasNext(){
            return i>0;
        }

        public Item next(){
            return data[--i];
        }

        public void remove(){

        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> testStack = new ArrayStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        for (Integer i:testStack){
            System.out.println(i);
        }
        testStack.pop();
        for (Integer i:testStack){
            System.out.println(i);
        }
    }
}
```



### 栈的链式存储

​	设定一个`top`指针表示栈顶，所以显然当`top`为`null`时，表示栈空。入栈：新建一个`oldTop`变量指向此时的`top`指向，再让`top`指向新插入的元素结点，再设其`next`指针指向`oldTop`；出栈：只需在取出元素之后让栈顶指针指向下一个元素即可，完整代码如下：

```java
public class Stack<Item> implements Iterable<Item> {
    private Node top;
    private int N;

    private class Node{
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return top==null;
    }

    public int length(){
        return N;
    }

    public void push(Item item){
        Node oldTop = top;
        top = new Node(item,oldTop);
        N = N + 1;
    }

    public Item pop(){
        Item item = top.item;
        top = top.next;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{

        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
```