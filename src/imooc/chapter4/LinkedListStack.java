package imooc.chapter4;

import imooc.chapter3.ArrayStack;
import imooc.chapter3.Stack;

import java.util.Random;

/**
 * Created on 2020/1/31 0031
 * BY Jianlong
 * 使用链表实现栈
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:0 top ");
        res.append(linkedList.toString());
        return res.toString();
    }

    // 计算运行opCount次入栈出栈操作所耗费时间
    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i=0; i<opCount; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i=0; i<opCount; i++){
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayStack<Integer> aStack = new ArrayStack<>();
        double time1 = testStack(aStack, opCount);

        LinkedListStack<Integer> lStack = new LinkedListStack<>();
        double time2 = testStack(lStack, opCount);

        System.out.println("time1 = " + time1 + ", time2 = " + time2);
    }
}