package imooc.chapter5;

/**
 * Created on 2020/3/4 0004
 * BY Jianlong
 * 运用递归，求解数组的值
 */
public class Sum {
    // 面向用户函数
    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    // 递归函数
    private static int sum(int[] arr, int begin){
        if (begin == arr.length){
            return 0;
        }

        return arr[begin] + sum(arr, begin+1);
    }
}
