package mooc.week2;

import java.util.Iterator;

/**
 * Created on 2019/7/23 0023
 * BY Jianlong
 */
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
