package course;

/**
 * Created on 2019/11/27 0027
 * BY Jianlong
 * 0-1��������
 */
public class BagProblem {
    /**
     * ��5����Ʒ������ֱ���3��5��7��8��9����ֵ��4��6��7��9��10����������Ϊ22
     * ���
     */

    public void func(){
        // ���ȹ���һ��������Ϊ��
        // 6��23�У��д���ǰi����Ʒ; �д��������ֱ�Ϊ0...22
        int[][] table = new int[6][23];

        int[] volume = {0,3,5,7,8,9};
        int[] values = {0,4,6,7,9,10};


        // ��ʼ���
        for (int i=0; i<table.length; i++){
            for (int j=0; j<table[0].length; j++){
                // ��û����Ʒ���߱�������Ϊ0ʱ������Ϊ0
                if (i==0 || j==0){
                    table[i][j] = 0;
                } else {
                    // ���j<��i����Ʒ������,��ôtable[i][j]=table[i-1][j]
                    if (j < volume[i]){
                        table[i][j] = table[i-1][j];
                    } else{
                        // ���j>��i����Ʒ������,��ô��ֵ�͵���max{table[i-1][j] table[i-1][j-si]}
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
