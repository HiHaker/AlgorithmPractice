package imooc.chapter3;

/**
 * Created on 2020/1/13 0013
 * BY Jianlong
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    // 队首
    private int front;
    // 队尾
    private int tail;
    private int size;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0 ; i < size ; i ++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public void enqueue(E e) {
        // 判断队列是否满
        if ((tail+1) % data.length == front){
            // 进行扩容操作
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    @Override
    public E dequeue() {
        // 如果队列为空，抛出异常
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        // 如果队列为空，抛出异常
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i=front; i!=tail; i=(i+1)%data.length){
            res.append(data[i]);
            // 如果不是队列中的最后一个元素的话
            if ((i+1)%data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}