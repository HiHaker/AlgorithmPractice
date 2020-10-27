package CCF;

import java.util.Scanner;

/**
 * Created on 2020/4/19 0019
 * BY Jianlong
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int n, m, r, c, minNum, count=0;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();

        int[][] matrix = new int[n][m];
        minNum = Math.min(n, m);
        int loop = (int) Math.round(minNum/2.0);

        // 填充矩阵
        for (int i=0; i<loop; i++){
            // 上
            for (int j=i; j<m-i; j++){
                matrix[i][j] = ++count;
            }
            // 右
            for (int k=i+1; k<n-i; k++){
                matrix[k][m-i-1] = ++count;
            }
            // 下
            for (int p=m-i-2; p>=i; p--){
                if (matrix[n-i-1][p] > 0){
                    continue;
                }
                matrix[n-i-1][p] = ++count;
            }
            // 左
            for (int q=n-i-2; q>i; q--){
                matrix[q][i] = ++count;
            }
        }
//
//        for (int i=0; i<n; i++){
//            for (int j=0; j<m; j++){
//                System.out.printf("%2d", matrix[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        System.out.print(matrix[r-1][c-1]);
    }
}
