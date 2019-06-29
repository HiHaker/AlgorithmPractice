package chapter1;

import java.util.*;

public class Console1 {
    // 1.1.9 将一个正整数N转换为二进制表示的字符串
    public String myToBinaryStr(int N){
        String s="";
        String result="";

        for (int n=N; n>0; n/= 2){
            s = s + (n%2);
        }
        // 逆序
        for (int i=s.length()-1; i>=0; i--){
            result=result+s.charAt(i);
        }

        return result;
    }

    // 打印二维布尔数组
    public void printArray(){
        boolean b1[][] = new boolean[4][5];
        for (int i=0; i<b1.length; i++){
            for (int j=0; j<b1[0].length; j++)
                System.out.println(i+","+j+":"+b1[i][j]);
        }
    }

    // 打印出M行N列的矩阵的转置
    public void printTransArr(){
        int m=7;
        int n=8;
        int[][] num1 = new int[m][n];
        int[][] num2 = new int[n][m];

        for (int i=0; i<num1.length; i++){
            for (int j=0; j<num1[0].length; j++)
                num2[j][i]=num1[i][j];
        }

        for (int i=0; i<num1.length; i++){
            for (int j=0; j<num1[0].length; j++){
                System.out.print(num1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i=0; i<num2.length; i++){
            for (int j=0; j<num2[0].length; j++){
                System.out.print(num2[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 1.1.14 编写一个静态方法lg，接收一个整型参数N，返回不大于log2N的最大整数

    // 1.1.15
    public int[] histogram(int[] a, int M){

        Set<Integer> s1 = new HashSet<>();
        int[] result = new int[M];
        for (int num:a){
            s1.add(num);
        }

        int j=0;
        for (int temp:s1){
            int count = 0;
            for (int i=0; i<a.length; i++)
                if(temp==a[i]){
                    count++;
                }
            result[j++]=count;
        }

        return result;
    }

    // 1.1.20编写一个递归的静态方法计算ln(N!)
    public static double calLNN(int N){
        // 由对数的基本公式
        if (N>1)
            return Math.log(N) + calLNN(N-1);
        else
            return 0;
    }

    // 1.1.21
    public void specPrint(){
        Scanner in = new Scanner(System.in);

        String inputs;
        String[] result;
        RowsData r;
        List<RowsData> l = new ArrayList<RowsData>();

        while((inputs=in.nextLine()).length()!=0){
            result = inputs.split(" ");
            r = new RowsData(result[0], Integer.parseInt(result[1]), Integer.parseInt(result[2]));
            l.add(r);
        }

        for (RowsData t:l){
            System.out.println(t.get_name()+" "+t.get_num1()+" "+t.get_num2()+" "+(t.get_num1()/t.get_num2()));
        }
    }

    public static void main(String[] args){
        Console1 c1 = new Console1();
        c1.specPrint();
    }
}
