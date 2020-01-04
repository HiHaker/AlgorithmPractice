package course;

/**
 * Created on 2019/11/27 0027
 * BY Jianlong
 * 0-1背包问题
 */
public class BagProblem {
    /**
     * 有5个物品，体积分别是3，5，7，8，9，价值是4，6，7，9，10，背包容量为22
     * 填表
     */

    public void func(){
        // 首先构造一个矩阵作为表
        // 6行23列，行代表前i项物品; 列代表容量分别为0...22
        int[][] table = new int[6][23];

        int[] volume = {0,3,5,7,8,9};
        int[] values = {0,4,6,7,9,10};


        // 开始填表
        for (int i=0; i<table.length; i++){
            for (int j=0; j<table[0].length; j++){
                // 当没有物品或者背包容量为0时，收益为0
                if (i==0 || j==0){
                    table[i][j] = 0;
                } else {
                    // 如果j<第i项物品的容量,那么table[i][j]=table[i-1][j]
                    if (j < volume[i]){
                        table[i][j] = table[i-1][j];
                    } else{
                        // 如果j>第i项物品的容量,那么价值就等于max{table[i-1][j] table[i-1][j-si]}
                        table[i][j] = Math.max(table[i-1][j], table[i-1][j-volume[i]] + values[i]);
                    }
                }
            }
        }

        for (int i=0; i<table.length; i++){
            for (int j=0; j<table[0].length; j++){
                System.out.print(table[i][j] + "+");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BagProblem bp = new BagProblem();
        bp.func();
    }
}
