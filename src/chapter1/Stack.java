package chapter1;

/**
 * Created on 2019/7/1 0001
 * BY Jianlong
 */
public class Stack<Item> {
    private Node first; //栈顶
    private int N;

    // 定义一个私有内部类
    private class Node{
        Item item;
        Node next;
    }

    // 当first指针为null或N为0时，栈空
    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return N;
    }

    // 入栈
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N = N+1;
    }

    // 出栈
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N = N-1;
        return item;
    }
}
