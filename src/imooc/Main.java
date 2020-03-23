package imooc;


import imooc.chapter6.BST;

import java.util.Stack;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        stack.push(null);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

    }
}