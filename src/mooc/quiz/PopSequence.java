package mooc.quiz;

import java.util.Scanner;

/**
 * Created on 2019/7/25 0025
 * BY Jianlong
 */
public class PopSequence {

    private class Stack{
        int N;
        Node top;
        class Node{
            int data;
            Node next;
        }

        int length(){
            return N;
        }

        boolean isEmpty(){
            return top==null;
        }

        int top(){
            return top.data;
        }

        void push(int data){
            Node oldTop = top;
            top = new Node();
            top.data = data;
            top.next = oldTop;
            N = N + 1;
        }

        int pop(){
            int data = top.data;
            top = top.next;
            N = N - 1;
            return data;
        }
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        Stack s;
        String[] line = in.nextLine().split(" ");
        int beginNum;
        int stackSize = Integer.parseInt(line[0]); // 栈的大小
        int sumOfNum = Integer.parseInt(line[1]); // 数的总数
        int sequences = Integer.parseInt(line[2]); // 需要判断的队列总数
        boolean[] judge = new boolean[sequences]; // 对整个sequence的判断结果

        A:for (int i=0; i<sequences; i++){
            s = new Stack();
            beginNum = 1;
            line = in.nextLine().split(" ");
            // 遍历sequence数列
            for (int j=0; j<sumOfNum; j++){
                int temp = Integer.parseInt(line[j]);
                // 当栈为空或栈顶元素小于当前要比较的元素时且栈不满，将元素入栈
                while (s.isEmpty() || s.top()<temp&&(s.length()<stackSize)){
                    s.push(beginNum++);
                }
                if (s.top() == temp){
                    s.pop();
                    continue;
                }
                if (s.top()<temp && s.length()==stackSize || s.top()>temp){
                    judge[i] = false;
                    continue A;
                }
            }
            judge[i] = true;
        }

        for (int i=0; i<sequences; i++){
            if (judge[i]){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) {
        PopSequence p = new PopSequence();
        p.start();
    }
}