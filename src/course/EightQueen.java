package course;

import java.util.LinkedList;

/**
 * Created on 2020/1/4 0004
 * BY Jianlong
 * 8皇后问题
 */
public class EightQueen {
    // 皇后的个数
    private static final int NUM = 8;
    // 摆放的种类的计数
    private static int count;

    // 静态内部类
    // 在初始化时会进行加载，对于经常使用的类，应该使用static关键字
    static class Location{
        // 代表行
        private int x;
        // 代表列
        private int y;

        // 构造函数
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // toString
        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    // 打印出某一个可能的结果
    public void printLocation(LinkedList<Location> list){
        for (Location loc:list){
            System.out.print(loc + "\t");
        }
        System.out.println();
    }

    // 判断放置位置是否合理(剪枝函数)
    public boolean isLegal(LinkedList<Location> list, Location loc){
        for (Location each:list){
            // 不能处于同一行或同一列或同一斜线（斜率为+-1）
            if (loc.x == each.x || loc.y == each.y){
                return false;
            } else if (Math.abs(loc.x-each.x) == Math.abs(loc.y-each.y)){
                return false;
            }
        }
        return true;
    }

    // 算法的主函数-使用回溯法
    // x-行
    // y-列
    public void eightQueen(LinkedList<Location> list, int x, int y){
        // 如果list的大小为设定的皇后的个数，说明所有皇后都已经放置在了可行的位置，此时打印输出
        if (list.size() == NUM){
            printLocation(list);
            count++;
            return;
        }

        // 对于后面的每一列，如果位置检查可行就放置，之后放置下一行
        for (int i=y; i<NUM; i++){
            Location loc = new Location(x, i);
            if (isLegal(list, loc)){
                // 加入list
                list.add(loc);
                // 递归地放置下一行的元素，从第0列开始放置
                eightQueen(list, x+1, 0);
                // 递归函数返回，说明找到可能的位置或都不行，所以要进行回溯
                list.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        LinkedList<Location> list = new LinkedList<>();
        // 从第0行第0列开始
        eq.eightQueen(list, 0, 0);
        System.out.println(NUM + "皇后共有" + count + "种方式.");
    }

}