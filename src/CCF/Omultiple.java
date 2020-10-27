package CCF;

import java.util.Scanner;

/**
 * Created on 2020/4/19 0019
 * BY Jianlong
 */
public class Omultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c, n, count=0;

        n = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        for (int i=1; i<=n; i++){
            if (i%a==0 || i%b==0 || i%c==0){
                count++;
            }
        }

        count = n - count;

        System.out.print(count);
    }
}
