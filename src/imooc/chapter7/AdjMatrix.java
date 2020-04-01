package imooc.chapter7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 2020/4/1 0001
 * BY Jianlong
 */
public class AdjMatrix {
    // 图中的顶点
    private int V;
    // 图中的边
    private int E;
    // 邻接矩阵
    private int[][] adj;

    // 构造函数-传入一个文件名
    public AdjMatrix(String fileName){
        File file = new File(fileName);
        // 捕获异常
        // java7语法，会自动关闭资源
        try (Scanner scanner = new Scanner(file)) {
            // 读入顶点数
            V = scanner.nextInt();
            // 对数据的合法性做一个判断
            if (V < 0){
                throw new IllegalArgumentException("The value of Vertex must be non-negative!");
            }

            // 创建二维数组
            adj = new int[V][V];
            // 读入边数
            E = scanner.nextInt();
            if (V < 0){
                throw new IllegalArgumentException("The value of Edge must be non-negative!");
            }
            // 循环读入每一条边
            for (int i=0; i<E; i++)
            {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                // 检测自环边和平行边
                if (a == b){
                    throw new IllegalArgumentException("Self Loop is detective!");
                }
                if (adj[a][b] == 1){
                    throw new IllegalArgumentException("Parallel Edge is detective!");
                }

                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 验证顶点是否合法
    private void validateVertex(int v){
        if ( v>0 || v>=V){
            throw new IllegalArgumentException("vertex" + v + "is invalid!");
        }
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    // 查看图中是否存在边
    public boolean hasEdge(int a, int b){
        validateVertex(a);
        validateVertex(b);

        return adj[a][b] == 1;
    }

    // 返回和一个顶点相邻的其他顶点
    public ArrayList<Integer> adj(int v){
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<V; i++){
            if (adj[v][i] == 1){
                res.add(i);
            }
        }

        return res;
    }

    // 求一个顶点的度
    public int degree(int v){
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // 顶点信息和边的信息
        sb.append(String.format(" V: %d, E: %d\n", V, E));

        // 遍历每一条边
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++){
                sb.append(adj[i][j] + " ");
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("./src/imooc/chapter7/g.txt");
        System.out.println(adjMatrix);
    }
}
