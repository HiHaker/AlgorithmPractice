最近在开始看《算法第四版》，刚学习了两天，感觉还是收获很大。

照着书上实现了一个下压栈：

### 定容定类型的栈

栈的结构特点是先进先出，这里使用`String`数据类型，学习过数据结构的话应该不难写出下面的基础代码，使用基本的数据类型数组来进行实现，和其他语言实现类似（C语言也是使用数组进行栈的实现）

有我们熟悉的API：`isEmpty()`，`push()`，`pop()`

```java
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N; // 当前的size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        a[N++] = item;
    }

    public String pop(){
        return a[--N];
    }
}
```

当然，这个实现缺点也很明显，栈的数据类型不能变，而且不能动态增长。

那么，想要实现动态增长，就需要用到Java的泛型，之前也没有用到泛型，也相应的练习了段简单的泛型代码如下，定义了一个简单的泛型类Pair，如字面意思，存储一对任意类型元素并有它相应方法。

```java
public class Pair<T> {
    private T first;
    private T second;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return this.first;
    }

    public T getSecond(){
        return this.second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
```

有了泛型的基础，还有一个问题需要解决，就是让它的空间可以动态的增长，写C语言时候用到的函数是`malloc()`内存分配的方法，我们可以想到使用Java里的`new` 关键字。

这里要注意一个点，Java里不允许创建泛型数组，所以需要使用类型转换的方法来做

```java
// 将栈移动到新的大小为max的数组中
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i<N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }
```

那么有了上面的基础，我们就可以写出最终版本了！

```java
import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // 栈元素
    private int N = 0; // 当前元素数量

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

    // 入栈
    public void push(Item item){
        if (N == a.length){
            this.resize(2*a.length);
        }
        a[N++] = item;
    }

    // 出栈
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

    // 内部类
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
```