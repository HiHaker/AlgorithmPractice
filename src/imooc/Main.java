package imooc;


import imooc.chapter4.LinkedListQueue;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Main {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i=0; i<10; i++){
            queue.enqueue(i);
            if (i%3 == 2){
                queue.dequeue();
            }
            System.out.println(queue);
        }
    }
}