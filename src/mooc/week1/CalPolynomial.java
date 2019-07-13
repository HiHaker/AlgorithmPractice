package mooc.week1;

/**
 * Created on 2019/7/13 0013
 * BY Jianlong
 */
public class CalPolynomial {

    public void f1(double[] a, double x){
        double sum = 0;
        for (int i=0; i<9; i++){
            sum += a[i]*Math.pow(x,i);
        }
    }

    public void f2(double[] a, double x){
        double p = a[8];
        for (int i=8; i>0; i--){
            p = a[i-1] + p*x;
        }
    }

    public static void main(String[] args) {
        CalPolynomial cp = new CalPolynomial();
        double[] a = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        double x = 1.1;

        long start1 = System.nanoTime();
        cp.f1(a,x);
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);

        long start2 = System.nanoTime();
        cp.f2(a,x);
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);

    }
}