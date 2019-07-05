package chapter1;

import java.util.Iterator;

/**
 * Created on 2019/7/5 0005
 * BY Jianlong
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private class Node{
        Item item;
        Node next;
    }
    private int N;

    public boolean isEmpty(){
        return first == null; //或者N == 0
    }

    public int size(){
        return N;
    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
