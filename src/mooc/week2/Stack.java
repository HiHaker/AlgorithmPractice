package mooc.week2;

import java.util.Iterator;

/**
 * Created on 2019/7/23 0023
 * BY Jianlong
 */
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
