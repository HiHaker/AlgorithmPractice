package Base;

/**
 * Created on 2019/6/29 0029
 * BY hujianlong
 * 获得一个字符串数组的最小值和最大值（按照字符串的首字母顺序，如果按照字典顺序是第一个字符串比第二个字符串靠前，返回负值；否则返回正值）
 */
public class ArrayAlg {
//    泛型方法
    public static Pair<String> minmax(String[] a){
        if (a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i=1; i<a.length; i++){
            if (min.compareTo(a[i]) > 0){
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }
}
