package chapter1;

import java.util.Iterator;

/**
 * Created on 2019/7/1 0001
 * BY Jianlong
 */
public class Stack<Item> implements Iterable<Item>{
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
