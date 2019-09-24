package course;

import java.util.Scanner;

/**
 * Created on 2019/9/22 0022
 * BY Jianlong
 */
public class MySort {
    // 选择排序
    public int[] selectionSort(int[] list){
        int min; // 存储每一趟的最小值
        int minIndex;
        int mid; //交换的中间值
        // 要进行n-1趟
        for (int i=0; i<list.length-1; i++){
            min = list[i];
            minIndex = i;
            for (int j=i+1; j<list.length; j++){
                if (list[j] < min){
                    min = list[j];
                    minIndex = j;
                }
            }
            mid = list[i];
            list[i] = list[minIndex];
            list[minIndex] = mid;
        }
        return list;
    }

    // 插入排序
    public int[] insertSort(int[] list){
        int insertNum;
        for (int i=1; i<list.length; i++){
            insertNum = list[i];
            // j表示插入的位置
            for (int j=i; j>=0; j--){
                if (j == 0){
                    list[j] = insertNum;
                    break;
                }
                list[j] = list[j-1];
                if (insertNum > list[j]){
                    list[j] = insertNum;
                    break;
                }
            }
        }
        return list;
    }

    // 归并排序（递归实现）
    public int[] mergeSort(int[] list){
        // 基线条件（数组长度为1）
        if (list.length == 1){
            return list;
        }

        // 将数组分为两个部分
        int mid = list.length/2;
        int[] listLeft = new int[mid];
        int[] listRight = new int[list.length-mid];
        for (int i=0; i<mid; i++){
            listLeft[i] = list[i];
        }
        for (int j=0; j<list.length-mid; j++){
            listRight[j] = list[mid+j];
        }

        // 递归条件
        return this.mergeList(mergeSort(listLeft),mergeSort(listRight));
    }

    public int[] mergeList(int[] list1, int[] list2){
        int[] resultList = new int[list1.length+list2.length];
        int i=0; // resultList的索引
        int j=0; // list1的索引
        int k=0; //list2的索引

        while (j<list1.length && k<list2.length){
            if (list1[j] < list2[k]){
                resultList[i] = list1[j];
                j = j+1;
            } else {
                resultList[i] = list2[k];
                k = k+1;
            }
            i = i+1;
        }

        if (j>=list1.length){
            for (int r=k; r<list2.length; r++){
                resultList[i] = list2[r];
                i = i+1;
            }
        }
        if (k>=list2.length){
            for (int r=j; r<list1.length; r++){
                resultList[i] = list1[r];
                i = i+1;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        MySort mySort = new MySort();
        Scanner in = new Scanner(System.in); // 标准输入流

        long beginTime;
        long endTime;

        String[] datas;
        int[] result;

        datas = in.nextLine().split(" ");
        int[] list1 = new int[datas.length];
        for (int i=0; i<datas.length; i++){
            list1[i] = Integer.parseInt(datas[i]);
        }

        // 得到当前的毫秒数
        beginTime = System.nanoTime();
        for (int i=0; i<100; i++){
            mySort.mergeSort(list1);
        }
        // 结束时的毫秒数
        endTime = System.nanoTime();
        System.out.println(endTime-beginTime);

        beginTime = System.nanoTime();
        for (int i=0; i<100; i++){
            mySort.insertSort(list1);
        }
        endTime = System.nanoTime();
        System.out.println(endTime-beginTime);

        beginTime = System.nanoTime();
        for (int i=0; i<100; i++){
            mySort.selectionSort(list1);
        }
        endTime = System.nanoTime();
        System.out.println(endTime-beginTime);
//        datas = in.nextLine().split(" ");
//        int[] list2 = new int[datas.length];
//        for (int i=0; i<datas.length; i++){
//            list2[i] = Integer.parseInt(datas[i]);
//        }
// 测试merge合并数组
//        result = mySort.mergeList(list1,list2);
// 测试归并排序
//        result = mySort.mergeSort(list1);
// 测试插入排序
//        result = mySort.insertSort(list1);
// 测试选择排序
//        result = mySort.selectionSort(list1);
//        for (int j=0; j< list1.length; j++){
//            System.out.print(list1[j]);
//        }
//        System.out.println();
//        for (int j=0; j< list2.length; j++){
//            System.out.print(list2[j]);
//        }
//        System.out.println();
//        for (int j=0; j< result.length; j++){
//            System.out.print(result[j]);
//        }
    }
}