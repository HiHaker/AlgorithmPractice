package chapter1;

/**
 * Created on 2019/6/30 0030
 * BY hujianlong
 * 使用泛型
 */
public class FixedCapacityStack<Item> {
    private Item[] a; // Stack entries
    private int N; // size

    public FixedCapacityStack(int cap){
        // 在Java中不允许创建泛型数组，使用类型转换
       a = (Item[]) new Object[cap];
    }

    // 将栈移动到新的大小为max的数组中
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i<N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        // 因为N代表size，所以当N等于length时说明满了，需要增加空间
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
}