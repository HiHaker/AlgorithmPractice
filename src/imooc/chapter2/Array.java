package imooc.chapter2;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Array<E> {
    private E[] data;
    // 有效元素
    private int size;

    // 无参数的构造函数
    public Array(){
        this(10);
    }

    // 构造函数
    public Array(int capacity){
        // Java不支持new一个泛型数组
        data = (E[])new Object[capacity];
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public E get(int index){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index, E e){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    // 是否包含某个元素
    public boolean contains(E e){
        for (int i=0; i<size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 找到元素e对应的索引
    public int find(E e){
        for (int i=0; i<size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 代码复用
    // 头添加元素
    public void addFirst(E e){
        add(0,e);
    }

    // 末尾增加元素
    public void addLast(E e){
        add(size,e);
    }

    private void resize(int newcapacity){
        E[] newData = (E[]) new Object[newcapacity];
        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    // 位置插入元素
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and <= size");
        }

        if (size == data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full!");
            resize(2 * data.length);
        }

        for (int i=size-1; i>=index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and <= size");
        }

        E ret = data[index];
        for (int i= index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }

        return ret;
    }

    // 从数组中删除元素e（第一个元素）
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i=0; i<size; i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}