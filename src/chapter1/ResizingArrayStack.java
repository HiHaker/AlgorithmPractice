package chapter1;

import java.util.Iterator;

/**
 * Created on 2019/6/30 0030
 * BY hujianlong
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // 栈元素
    private int N = 0; // 元素数量

    public boolean isEmpty(){
        return  N==0;
    }

    public int size(){
        return N;
    }

    // 将栈移动到新的大小为max的数组中
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i<N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if (N == a.length){
            this.resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null; // 避免对象游离
        if (N>0 && N==a.length/4){
            this.resize(a.length/2);
        }
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        public boolean hasNext(){
            return i> 0;
        }

        public Item next(){
            return a[--i];
        }

        public void remove(){

        }
    }
}
