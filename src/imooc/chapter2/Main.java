package imooc.chapter2;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for(int i=0; i<10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,99);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

        arr.removeElement(99);
        System.out.println(arr);
    }
}