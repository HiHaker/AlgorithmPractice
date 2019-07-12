package mooc.week1;

/**
 * Created on 2019/7/12 0012
 * BY Jianlong
 */
public class PrintNTest {

    // 遍历实现
    public void printN1(int N){
        for (int i=1; i<N; i++){
            System.out.println(i);
        }
    }

    //递归实现
    public void printN2(int N){
        if (N > 0){
            printN2(N - 1);
            System.out.println(N);
        }
    }

    public static void main(String[] args) {
        PrintNTest test = new PrintNTest();
        test.printN1(10000);
        test.printN2(10000); // 栈溢出
    }
}
