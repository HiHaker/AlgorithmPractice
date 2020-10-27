package imooc;


import imooc.chapter2.Array;

import java.util.*;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> myArr = new Array<>();
        myArr.addLast(1);
        myArr.addLast(2);
        myArr.addLast(3);
        myArr.addLast(4);
        System.out.println(myArr);
        myArr.add(0, 5);
        System.out.println(myArr);
        myArr.add(1,6);
        System.out.println(myArr);
        myArr.remove(5);
        System.out.println(myArr);
    }
}