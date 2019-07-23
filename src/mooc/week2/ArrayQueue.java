package mooc.week2;

/**
 * Created on 2019/7/23 0023
 * BY Jianlong
 */
public class ArrayQueue<Item> {
    private Item[] data;
    private int first;
    private int last;
    private int size;

    public ArrayQueue(int size){
        data = (Item[]) new Object[size];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int length(){
        return size;
    }

    public void addQueue(Item item){
        // 先判断是否满了
        if (size == data.length){
            System.out.println("队列已满!");
            return;
        } else{
            last = (last + 1)%data.length;
            data[last] = item;
            size = size+1;
        }
    }

    public Item deleteQueue(){
        // 先判断是否为空
        if (size == 0){
            System.out.println("队列为空!");
            return null;
        } else{
            first = (first + 1)%data.length;
            size = size-1;
            return data[first];
        }
    }

    public void printData(){
        int current = (first+1)%data.length;
        for (int i=1; i<=size; i++){
            System.out.print(data[current] + " ");
            current = (current+1)%data.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> testQ = new ArrayQueue<>(5);
        testQ.addQueue(1);
        testQ.addQueue(2);
        testQ.deleteQueue();
        testQ.addQueue(3);
        testQ.deleteQueue();
        testQ.addQueue(4);
        testQ.addQueue(5);
        testQ.printData();
    }
}
