package course;

import java.util.Scanner;

/**
 * Created on 2019/9/22 0022
 * BY Jianlong
 */
public class MySort {
    // 选择排序
    public void selectionSort(double[] list){
        double min; // 存储每一趟的最小值
        int minIndex;
        double mid; //交换的中间值
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
    }

    // 选择排序-递归实现
    // 首先判断此时子数组的开始索引k是不是数组的最后一个元素，如果是，证明已经有序，return
    // 如果不是，将子数组中最小的元素筛选出来与子数组的第一个元素进行交换
    // 对后面的从索引k+1到最后一个索引的元素的子数组进行选择排序
    public void selectionSortRecursive(double[] list, int index){
        if (index == list.length - 1){
            return;
        }

        int minIndex = index;
        double min = list[minIndex];
        double mid = 0;
        // 找出从开始索引到list结束的最小的元素
        for (int i=index+1; i<list.length; i++){
            if (list[i] < min){
                min = list[i];
                minIndex = i;
            }
        }
        // 把索引位置的元素和最小元素交换
        mid = list[index];
        list[index] = list[minIndex];
        list[minIndex] = mid;
        // 对后面的子数组进行选择排序
        selectionSortRecursive(list, index+1);
    }

    // 插入排序
    public void insertSort(double[] list){
        double insertNum;
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
    }

    // 插入排序-递归实现
    // 首先判断此时要排序的数组的长度，如果是1，不用进行排序了，直接返回
    // 对前n-1个元素进行排序（使前n-1个元素有序）
    // 将第n个元素插入到前n-1个元素之中
    public void insertSortRecursive(double[] list, int size){
        // 数组长度为1，直接返回
        if (size == 1){
            return;
        }
        // 使前n-1个元素有序
        insertSortRecursive(list, size-1);
        // 将最后一个元素插入进去
        // 数组最后一个元素的索引
        double insertNum = list[size-1];
        // j表示插入的位置
        for (int i=size-1; i>=0; i--){
            if (i == 0){
                list[i] = insertNum;
                break;
            }
            list[i] = list[i-1];
            if (insertNum > list[i]){
                list[i] = insertNum;
                break;
            }
        }
    }

    // 冒泡排序
    public void bubbleSort(double[] list){
        // 假设数组的元素规模为n，循环遍历整个待排序数组n-1次
        // 每一次循环比较相邻两个数，较大的数放在右边，这样，循环1次，整个数组中最大的数就会冒到最后面
        // 循环n-1次，整个数组就会变得有序
        double mid; // 交换的中间值存储变量
        for (int i=1; i<list.length; i++){
            for (int j=0; j<list.length-i; j++){
                if (list[j] > list[j+1]){
                    // 交换
                    mid = list[j];
                    list[j] = list[j+1];
                    list[j+1] = mid;
                }
            }
        }
    }

    // 冒泡排序-递归实现
    public void bubbleSortRecursive(double[] list, int endIndex){
        if (endIndex == 0){
            return;
        }
        double mid;
        // 将子数组中最大的一个数冒到最后边
        for (int i=0; i<endIndex; i++){
            if (list[i] > list[i+1]){
                // 交换
                mid = list[i];
                list[i] = list[i+1];
                list[i+1] = mid;
            }
        }
        bubbleSortRecursive(list, endIndex-1);
    }

    // 自底向上归并函数的merge操作
    // as,ae为第一个子数组的首尾
    // bs，be为第二个子数组的首尾
    public void merge(double[] list, int as, int ae, int bs, int be){
        int len = be-as+1; // 整个数组的长度
        double[] temp = new double[len];// 临时数组存放临时排序结果
        int i=as;
        int j=bs;
        int k=0;
        while (i<=ae&&j<=be){
            if (list[i] > list[j]){
                temp[k] = list[j];
                k++;
                j++;
            } else {
                temp[k] = list[i];
                k++;
                i++;
            }
        }

        if (i>ae){
            while (j<=be){
                temp[k]=list[j];
                j++;
                k++;
            }
        }

        if (j>be){
            while (i<=ae){
                temp[k]=list[i];
                i++;
                k++;
            }
        }

        for ( int r=0; r<len; r++){
            list[as+r] = temp[r];
        }
    }

    // 归并排序（自底向上）
    public void mergeSortDownToUp(double[] list){
        int index; // 索引
        int width; // 每一次需要排序的子数组大小
        int begin; // 子数组开始
        int end; // 两个子数组结尾
        int mid;

        // 最外层循环为每一次merge时每组数据的宽度，从1开始，以2倍的速度递增，直到宽度大于长度
        for ( width=1; width<list.length; width*=2){
            // 内层循环,每一次根据数据的宽度进行两组数据的归并
            // index每一次从数组开始位置开始，以2倍数据宽度的速度增加，到了不足1组数据时停止
            for ( index=0; index<(list.length-width); index+=width*2){
                // 判断是否是完整的两组数据
                // 如果当前子数组的第一个元素加上两倍的数组大小后大于数据长度，说明此子数组不是完整的两组数据
                if (index+width*2>list.length){
                    begin = index;
                    mid = index+width;
                    end = list.length-1;
                } else{
                    begin = index;
                    mid = index + width;
                    end = index + (2*width-1);
                }
                // 归并两个数组
                merge(list,begin,(mid-1),mid,end);
//                System.out.println("as: " +begin+ "ae: " +(mid-1)+ " bs: " +mid+ "be: " + end);
            }
//            System.out.println("--------------------------------------------------");
        }
    }

    // 归并排序（自顶向下，递归实现）
    public double[] mergeSort(double[] list){
        // 基线条件（数组长度为1）
        if (list.length == 1){
            return list;
        }

        // 将数组分为两个部分
        int mid = list.length/2;
        double[] listLeft = new double[mid];
        double[] listRight = new double[list.length-mid];
        for (int i=0; i<mid; i++){
            listLeft[i] = list[i];
        }
        for (int j=0; j<list.length-mid; j++){
            listRight[j] = list[mid+j];
        }

        // 递归条件
        return this.mergeList(mergeSort(listLeft),mergeSort(listRight));
    }

    public double[] mergeList(double[] list1, double[] list2){
        double[] resultList = new double[list1.length+list2.length];
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
//        double[] data = {5.0,4.0,3.0,2.0,1.0};
//        mySort.selectionSortRecursive(data,0);
//        mySort.insertSortRecursive(data,5);
//        data = mySort.mergeSort(data);
//        mySort.bubbleSort(data);
//        mySort.bubbleSortRecursive(data,4);
//        for (int i=0; i<data.length; i++){
//            System.out.println(data[i]);
//        }

        double[] data = new double[10000];
        // 生成0~100间的double
        for (int i=0; i<data.length; i++){
            data[i] = Math.random()*100;
        }

        long start;
        long end;

        start=System.currentTimeMillis();
//        mySort.bubbleSortRecursive(data,9999);
//        mySort.selectionSortRecursive(data,0);
//        mySort.insertSortRecursive(data,10000);
        mySort.mergeSort(data);
        end=System.currentTimeMillis();
        System.out.println(end-start);

//        for (int j=1; j<=3; j++){
//
//        }
//        double[] test = {6.0,5.0,4.0,3.0,2.0,1.0};
//        MySort mySort = new MySort();
//        Scanner in = new Scanner(System.in); // 标准输入流
//
//        long beginTime;
//        long endTime;
//
//        String[] datas;
//        int[] result;
//
//        datas = in.nextLine().split(" ");
//        int[] list1 = new int[datas.length];
//        for (int i=0; i<datas.length; i++){
//            list1[i] = Integer.parseInt(datas[i]);
//        }
//
//        // 得到当前的毫秒数
//        beginTime = System.nanoTime();
//        for (int i=0; i<100; i++){
//            mySort.mergeSort(list1);
//        }
//        // 结束时的毫秒数
//        endTime = System.nanoTime();
//        System.out.println(endTime-beginTime);
//
//        beginTime = System.nanoTime();
//        for (int i=0; i<100; i++){
//            mySort.insertSort(list1);
//        }
//        endTime = System.nanoTime();
//        System.out.println(endTime-beginTime);
//
//        beginTime = System.nanoTime();
//        for (int i=0; i<100; i++){
//            mySort.selectionSort(list1);
//        }
//        endTime = System.nanoTime();
//        System.out.println(endTime-beginTime);
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