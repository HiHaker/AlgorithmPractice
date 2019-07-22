package chapter1;

import java.util.Scanner;

/**
 * Created on 2019/6/29 0029
 * BY hujianlong
 * 定容栈
 */
public class FixedCapacityStackOfStrings {
    // 数组（顺序存储）
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

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
        Scanner in = new Scanner(System.in);
        String inputMsg;
        while (!(inputMsg = in.nextLine()).equals("")){
            s.push(inputMsg);
        }
        System.out.println("There are " + s.size() +" in the stack.");
        System.out.print("They are ");
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

}
