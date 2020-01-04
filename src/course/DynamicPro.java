package course;

import java.util.HashMap;

/**
 * Created on 2019/11/20 0020
 * BY Jianlong
 * 动态规划问题
 */
public class DynamicPro {

    // 动态规划解决单源最短路径问题
    public void func1(){
        // 构造一个图，使用hashmap
        HashMap<Integer, Object> graph = new HashMap();
        // 加入各个顶点
        HashMap<Integer, Object> vertex1 = new HashMap();
        vertex1.put(1,0);
        vertex1.put(2,9);
        vertex1.put(3,7);
        vertex1.put(4,3);
        vertex1.put(5,2);
        graph.put(1,vertex1);

        HashMap<Integer, Object> vertex2 = new HashMap();
        vertex2.put(2,0);
        vertex2.put(6,4);
        vertex2.put(7,2);
        vertex2.put(8,1);
        graph.put(2,vertex2);

        HashMap<Integer, Object> vertex3 = new HashMap();
        vertex3.put(3,0);
        vertex3.put(6,2);
        vertex3.put(7,7);
        graph.put(3,vertex3);

        HashMap<Integer, Object> vertex4 = new HashMap();
        vertex4.put(4,0);
        vertex4.put(8,11);
        graph.put(4,vertex4);

        HashMap<Integer, Object> vertex5 = new HashMap();
        vertex5.put(5,0);
        vertex5.put(7,11);
        vertex5.put(8,8);
        graph.put(5,vertex5);

        HashMap<Integer, Object> vertex6 = new HashMap();
        vertex6.put(6,0);
        vertex6.put(9,6);
        vertex6.put(10,5);
        graph.put(6,vertex6);

        HashMap<Integer, Object> vertex7 = new HashMap();
        vertex7.put(7,0);
        vertex7.put(9,4);
        vertex7.put(10,3);
        graph.put(7,vertex7);

        HashMap<Integer, Object> vertex8 = new HashMap();
        vertex8.put(8,0);
        vertex8.put(10,5);
        vertex8.put(11,6);
        graph.put(8,vertex8);

        HashMap<Integer, Object> vertex9 = new HashMap();
        vertex9.put(9,0);
        vertex9.put(12,4);
        graph.put(9,vertex9);

        HashMap<Integer, Object> vertex10 = new HashMap();
        vertex10.put(10,0);
        vertex10.put(12,2);
        graph.put(10,vertex10);

        HashMap<Integer, Object> vertex11 = new HashMap();
        vertex11.put(11,0);
        vertex11.put(12,5);
        graph.put(11,vertex11);

        HashMap<Integer, Object> vertex12 = new HashMap();
        vertex12.put(12,0);
        graph.put(12,vertex12);

        // 构造一个数组cost存储各个结点到目标结点的花费
        int[] cost = new int[13];
        // 构造一个数组path存储最短路径
        int[] path = new int[13];

        // 顶点到目标结点的最小花费
        int minCost;
        // 存储开销
        int tempCost;

        // 填充cost数组和path数组
        for (int i=11; i>=1; i--){
            minCost = 100;
            tempCost = 0;
            // 获得当前结点的邻接结点
            HashMap<Integer, Object> adj = (HashMap<Integer, Object>)graph.get(i);
            for (Integer v:adj.keySet()){
                // 计算出最小开销
                if (v != i){
                    tempCost = (Integer) adj.get(v) + cost[v];
                    if (tempCost < minCost){
                        minCost = tempCost;
                        path[i] = v;
                    }
                }
            }
            cost[i] = minCost;
        }

        for (int num:cost){
            System.out.println(num);
        }
    }

    public void func2(int start, int end){
        // 构造一个图，使用hashmap
        HashMap<Integer, Object> graph = new HashMap();
        // 加入各个顶点
        HashMap<Integer, Object> vertex1 = new HashMap();
        vertex1.put(1,0);
        vertex1.put(2,9);
        vertex1.put(3,7);
        vertex1.put(4,3);
        vertex1.put(5,2);
        graph.put(1,vertex1);

        HashMap<Integer, Object> vertex2 = new HashMap();
        vertex2.put(2,0);
        vertex2.put(6,4);
        vertex2.put(7,2);
        vertex2.put(8,1);
        graph.put(2,vertex2);

        HashMap<Integer, Object> vertex3 = new HashMap();
        vertex3.put(3,0);
        vertex3.put(6,2);
        vertex3.put(7,7);
        graph.put(3,vertex3);

        HashMap<Integer, Object> vertex4 = new HashMap();
        vertex4.put(4,0);
        vertex4.put(8,11);
        graph.put(4,vertex4);

        HashMap<Integer, Object> vertex5 = new HashMap();
        vertex5.put(5,0);
        vertex5.put(7,11);
        vertex5.put(8,8);
        graph.put(5,vertex5);

        HashMap<Integer, Object> vertex6 = new HashMap();
        vertex6.put(6,0);
        vertex6.put(9,6);
        vertex6.put(10,5);
        graph.put(6,vertex6);

        HashMap<Integer, Object> vertex7 = new HashMap();
        vertex7.put(7,0);
        vertex7.put(9,4);
        vertex7.put(10,3);
        graph.put(7,vertex7);

        HashMap<Integer, Object> vertex8 = new HashMap();
        vertex8.put(8,0);
        vertex8.put(10,5);
        vertex8.put(11,6);
        graph.put(8,vertex8);

        HashMap<Integer, Object> vertex9 = new HashMap();
        vertex9.put(9,0);
        vertex9.put(12,4);
        graph.put(9,vertex9);

        HashMap<Integer, Object> vertex10 = new HashMap();
        vertex10.put(10,0);
        vertex10.put(12,2);
        graph.put(10,vertex10);

        HashMap<Integer, Object> vertex11 = new HashMap();
        vertex11.put(11,0);
        vertex11.put(12,5);
        graph.put(11,vertex11);

        HashMap<Integer, Object> vertex12 = new HashMap();
        vertex12.put(12,0);
        graph.put(12,vertex12);

        // 构造一个数组cost存储各个结点到目标结点的花费
        int[] cost = new int[13];
        // 构造一个数组path存储最短路径
        int[] path = new int[13];

        // 顶点到目标结点的最小花费
        int minCost;
        // 存储开销
        int tempCost;

        // 填充cost数组和path数组
        for (int i=end-1; i>=start; i--){
            minCost = 100;
            tempCost = 0;
            // 获得当前结点的邻接结点
            HashMap<Integer, Object> adj = (HashMap<Integer, Object>)graph.get(i);
            for (Integer v:adj.keySet()){
                // 计算出最小开销
                if (v != i){
                    tempCost = (Integer) adj.get(v) + cost[v];
                    if (tempCost < minCost){
                        minCost = tempCost;
                        path[i] = v;
                    }
                }
            }
            cost[i] = minCost;
        }

        System.out.println("cost数组为：");
        for (int k=end; k>= start; k--){
            System.out.print(k + ":" + cost[k] + " ");
        }
        System.out.println();
        System.out.println("path数组为：");
        for (int k=end; k>= start; k--){
            System.out.print(k + ":" + path[k] + " ");
        }
        System.out.println();
        System.out.println("最短路径为：");
        int index = start;
        while (index != 0){
            System.out.print(index + " ");
            index = path[index];
        }
    }

    // 动态规划解决资源分配问题
    public void func3(){
        // 分配的价值表
        // 行的0，1，2分别代表A，B，C
        // 列的0，1，2，3，4，5分别代表分配1，2，3，4，5，6
        double[][] values = {
                {0,1.2,1.5,1.85,2.4,2.8,3.3},
                {0,1.8,2.0,2.25,2.4,2.5,2.6},
                {0,1.3,1.9,2.2,2.45,2.7,3.0}
        };
        // 一个利润表，二维数组，3*7，行代表A，B，C，列代表为前面产品分配的资源数
        // 先将利润表的第一行填好，因为A前没有产品了
        double[][] profit = {
                {0,1.2,1.5,1.85,2.4,2.8,3.3},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}
        };

        // 填充利润表

        for (int i=1, j=0; j<=6; j++){
            profit[i][j] = profit[i-1][6-j] + values[i][j];
        }

        int resources;
        int[] A = new int[7];
        int[] B = new int[7];
        double maxProfit;
        double tempProfit;

        for (int i=2, j=0; j<=6; j++){
            resources = 6-j;
            maxProfit = 0;
            for (int k=0; k<= resources; k++){
                tempProfit = values[0][resources-k] + values[1][k];
                if (tempProfit > maxProfit){
                    maxProfit = tempProfit;
                    A[j] = resources-k;
                    B[j] = k;
                }
            }
            profit[i][j] = values[2][j] + maxProfit;
        }

        for (int i=0; i<=2; i++){
            for (int j=0; j<=6; j++){
                System.out.print(profit[i][j] + " ");
            }
            System.out.println();
        }

        double MaxProfit = profit[2][0];
        int maxIndex = 0;
        for (int i=2, j=1; j<=6; j++){
            if (profit[i][j] > MaxProfit){
                MaxProfit = profit[i][j];
                maxIndex = j;
            }
        }

        System.out.println("C: " + maxIndex + ", A: " + A[maxIndex] + ", B: " + B[maxIndex]);

    }

    public void func4(int start, int end){
        // 构造一个图，使用hashmap
        HashMap<Integer, Object> graph = new HashMap();
        // 加入各个顶点
        HashMap<Integer, Object> vertex1 = new HashMap();
        vertex1.put(1,0);
        vertex1.put(2,3);
        vertex1.put(3,8);
        vertex1.put(4,5);
        graph.put(1,vertex1);

        HashMap<Integer, Object> vertex2 = new HashMap();
        vertex2.put(2,0);
        vertex2.put(5,1);
        vertex2.put(6,3);
        graph.put(2,vertex2);

        HashMap<Integer, Object> vertex3 = new HashMap();
        vertex3.put(3,0);
        vertex3.put(5,6);
        vertex3.put(7,5);
        graph.put(3,vertex3);

        HashMap<Integer, Object> vertex4 = new HashMap();
        vertex4.put(4,0);
        vertex4.put(6,7);
        vertex4.put(7,4);
        graph.put(4,vertex4);

        HashMap<Integer, Object> vertex5 = new HashMap();
        vertex5.put(5,0);
        vertex5.put(8,4);
        vertex5.put(9,2);
        graph.put(5,vertex5);

        HashMap<Integer, Object> vertex6 = new HashMap();
        vertex6.put(6,0);
        vertex6.put(8,3);
        vertex6.put(9,3);
        graph.put(6,vertex6);

        HashMap<Integer, Object> vertex7 = new HashMap();
        vertex7.put(7,0);
        vertex7.put(9,8);
        graph.put(7,vertex7);

        HashMap<Integer, Object> vertex8 = new HashMap();
        vertex8.put(8,0);
        vertex8.put(10,7);
        graph.put(8,vertex8);

        HashMap<Integer, Object> vertex9 = new HashMap();
        vertex9.put(9,0);
        vertex9.put(10,9);
        graph.put(9,vertex9);

        HashMap<Integer, Object> vertex10 = new HashMap();
        vertex10.put(10,0);
        graph.put(10,vertex10);

        // 构造一个数组cost存储各个结点到目标结点的花费
        int[] cost = new int[11];
        // 构造一个数组path存储最短路径
        int[] path = new int[11];

        // 顶点到目标结点的最小花费
        int minCost;
        // 存储开销
        int tempCost;

        // 填充cost数组和path数组
        for (int i=end-1; i>=start; i--){
            minCost = 100;
            tempCost = 0;
            // 获得当前结点的邻接结点
            HashMap<Integer, Object> adj = (HashMap<Integer, Object>)graph.get(i);
            for (Integer v:adj.keySet()){
                // 计算出最小开销
                if (v != i){
                    tempCost = (Integer) adj.get(v) + cost[v];
                    if (tempCost < minCost){
                        minCost = tempCost;
                        path[i] = v;
                    }
                }
            }
            cost[i] = minCost;
        }

        System.out.println("cost数组为：");
        for (int k=end; k>= start; k--){
            System.out.print(k + ":" + cost[k] + " ");
        }
        System.out.println();
        System.out.println("path数组为：");
        for (int k=end; k>= start; k--){
            System.out.print(k + ":" + path[k] + " ");
        }
        System.out.println();
        System.out.println("最短路径为：");
        int index = start;
        while (index != 0){
            System.out.print(index + " ");
            index = path[index];
        }
    }

    public static void main(String[] args) {
        DynamicPro dp = new DynamicPro();
        dp.func4(1,10);
    }
}