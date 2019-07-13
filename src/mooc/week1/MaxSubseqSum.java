package mooc.week1;

/**
 * Created on 2019/7/13 0013
 * BY Jianlong
 * 最大子列和问题
 */
public class MaxSubseqSum {

    // 算法1，遍历全部子列和，复杂度为n立方
    public void MaxSubseqSum1(int[] A, int N){
        int thisSum;
        int maxSum = 0;

        for (int i=0; i<N; i++){ //i是子列的左端位置
            for (int j=i; j<N; j++){ //j是子列的右端位置
                thisSum = 0;// 当前的子列和
                for (int k=i; k<j; k++){
                    thisSum += A[k];
                    if (thisSum > maxSum){
                        maxSum = thisSum; //最大子列和
                    } // if 结束
                } // for k 循环结束
            }// for j 循环结束
        } // for i 循环结束

    }

    // 算法2，遍历全部子列和，复杂度为n平方
    public void MaxSubseqSum2(int[] A, int N){
        int thisSum;
        int maxSum = 0;

        for (int i=0; i<N; i++){ // i是子列的左端位置
            thisSum = 0;
            for (int j=i; j<N; j++){ // j是子列的右端位置
                thisSum += A[j];
                if (thisSum > maxSum){
                    maxSum = thisSum;
                } // if 结束
            } // for j 循环结束
        } // for i 循环结束

    }

    // 算法4 在线处理算法
    public void MaxSubseqSum4(int[] A, int N){
        int thisSum = 0;
        int maxSum = 0;

        for (int i=0; i<N; i++){
            thisSum += A[i];
            if (thisSum > maxSum){
                maxSum = thisSum;
            }
            if (thisSum < 0){ // 如果当前为负数，则放弃
                thisSum = 0;
            }
        }
    }


}
