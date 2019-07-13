package mooc.quiz;

import java.util.Scanner;

/**
 * Created on 2019/7/13 0013
 * BY Jianlong
 */
public class MaxSubseqSum {

    public int maxSubseqSum(int[] A, int N){
        int thisSum = 0;
        int maxSum = 0;

        for (int i=0; i<N; i++){
            thisSum += A[i];
            if(thisSum > maxSum){
                maxSum = thisSum;
            }
            if (thisSum < 0){
                thisSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubseqSum ms = new MaxSubseqSum();
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

        System.out.print(ms.maxSubseqSum(num, N));
//        for (int i=0; i<N; i++){
//            System.out.println(num[i]);
//        }
    }
}
