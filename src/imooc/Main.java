package imooc;


import imooc.chapter6.BST;

import java.util.Stack;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> myBST = new BST<>();
        myBST.add(28);
        myBST.add(16);
        myBST.add(30);
        myBST.add(13);
        myBST.add(22);
        myBST.add(29);
        myBST.add(42);
        myBST.levelOrder();
        myBST.removeMin();
        System.out.println("--------------------------------");
        myBST.levelOrder();
        myBST.removeMax();
        System.out.println("--------------------------------");

        myBST.levelOrder();
    }
}