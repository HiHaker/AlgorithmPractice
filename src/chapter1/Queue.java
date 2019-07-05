package chapter1;

import java.util.Iterator;

/**
 * Created on 2019/7/2 0002
 * BY Jianlong
 * 先进先出队列
 */
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
