package mooc.quiz;

import java.util.Scanner;

/**
 * Created on 2019/7/13 0013
 * BY Jianlong
 */
public class MaximumSubseqSum {

    public boolean isAllnegative(int[] A, int N){
        boolean isAll = true;
        for (int i=0; i<N; i++){
            if(A[i] >= 0)
                isAll = false;
        }
        return isAll;
    }

    public void maxSubseqSum(int[] A, int N){
        int thisSum = 0;
        int maxSum = 0;
        int thisStart = 0;
        int start = 0;
        int thisEnd = 0;
        int end = 0;
        boolean isRefresh = true;

        for (int i=0; i<N; i++){
            if (isRefresh){
                thisStart = A[i]; // 当重新计算子列时，重置start
                isRefresh = false; // 重置状态
            }
            thisSum += A[i];
            thisEnd = A[i]; // 记录下当前的end
            if(thisSum > maxSum){
                start = thisStart;
                end = thisEnd;
                maxSum = thisSum;
            } else if (thisSum == maxSum){ // 如果子列和相等，取start加end和最小的值
                if ((thisStart + thisEnd) < (start + end)){
                    start = thisStart;
                    end = thisEnd;
                }
            }
            if (thisSum < 0){
                thisSum = 0;
                isRefresh = true; // 表示需要更新
            }
        }

        if (isAllnegative(A,N)){
            System.out.print(maxSum + " " + A[0] + " " + A[N-1]);
        }else{
            System.out.print(maxSum + " " + start + " " + end);
        }
    }

    public static void main(String[] args) {
        MaximumSubseqSum ms = new MaximumSubseqSum();
        String number;
        String[] numbers;
        int N = 0;

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        in.nextLine();
        number = in.nextLine();

        numbers = number.split(" ");

        N = numbers.length;
        int[] num = new int[N];
        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(numbers[i]);
        }

        ms.maxSubseqSum(num,N);
    }

}
