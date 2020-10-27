package Base;

/**
 * @Description
 * @Author Jianlong
 * @Date 2020-04-30 上午 10:22
 */
public class NewtonMethodSQRT {

    public static double sqrt(double c){
        if(c<0)
            return Double.NaN;
        double err = 1e-15;
        double t = c;
        while(Math.abs(1-t*t/c)>err)
            t = (c/t + t)/2.0;
        return t;
    }

    public static void main(String[] args) {
        double result = sqrt(6);
        System.out.println(result);
    }
}
