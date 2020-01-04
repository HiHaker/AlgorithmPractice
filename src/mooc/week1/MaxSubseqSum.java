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

    // 算法3 分而治之(DC)
    public int MaxSubSeqSum3( int[] list, int left, int right ) {
        // 分治法求list[left]到list[right]的最大子列和
        int MaxLeftSum; // 左边子数组的最大子列和
        int MaxRightSum; // 右边子数组的最大子列和

        int MaxLeftBorderSum; // 从边界线开始计算的左边的最大和
        int MaxRightBorderSum; // 从边界线开始计算的右边的最大和

        int LeftBorderSum; // 临时值
        int RightBorderSum; // 临时值
        int mid;

        // 子列只有1个数字,返回
        if( left == right )  {
            if( list[left] > 0 ){
                return list[left];
            }
            else{
                return 0;
            }
        }

        // 数组的中间值
        mid = ( left + right ) / 2;
        // 递归求得两边子列的最大和
        MaxLeftSum = MaxSubSeqSum3( list, left, mid );
        MaxRightSum = MaxSubSeqSum3( list, mid+1, right );

        // 下面求跨分界线的最大子列和
        MaxLeftBorderSum = 0;
        LeftBorderSum = 0;
        for( int i=mid; i>=left; i-- ) {
            LeftBorderSum += list[i];
            if( LeftBorderSum > MaxLeftBorderSum )
                MaxLeftBorderSum = LeftBorderSum;
        }

        MaxRightBorderSum = 0;
        RightBorderSum = 0;
        for( int j=mid+1; j<=right; j++ ) {
            RightBorderSum += list[j];
            if( RightBorderSum > MaxRightBorderSum )
                MaxRightBorderSum = RightBorderSum;
        }

        return Max(MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum);
    }

    // 求出三个数的最大的数
    public int Max(int a, int b, int c){
        if (a > b){
            if (a > c){
                return a;
            }
            else {
                return c;
            }
        } else{
            if (b > c){
                return b;
            } else{
                return c;
            }
        }
    }

    // 算法4 在线处理算法
    public void MaxSubseqSum4(int[] A, int N){
        int thisSum = 0;
        int maxSum = 0;
        int indexBegin = 0;
        int indexEnd = 0;

        for (int i=0; i<N; i++){
            thisSum += A[i];
            if (thisSum > maxSum){
                maxSum = thisSum;
                indexEnd = i;
            }
            if (thisSum < 0){ // 如果当前为负数，则放弃
                thisSum = 0;
                indexBegin = i+1;
            }
        }

        System.out.println("MaxSum: " + maxSum + ", indexBegin: " + indexBegin + ", indexEnd: " + indexEnd);
    }

    public static void main(String[] args) {
        MaxSubseqSum mss = new MaxSubseqSum();
        int[] numbers = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
//        mss.MaxSubseqSum4(numbers, 16);
        System.out.println("最大子列和为: " + mss.MaxSubSeqSum3(numbers,0,15));
    }

}
