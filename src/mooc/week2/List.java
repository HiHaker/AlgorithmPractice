package mooc.week2;

/**
 * Created on 2019/7/21 0021
 * BY Jianlong
 * 可自动增长大小的顺序表
 */
public class List<Item> {
    // Java不允许创建泛型数组，所以做强制类型转换
    private Item[] data;
    private int last = -1; // 表示List中最后一个元素的下标

    // 构造函数-创建List时指定大小
    public List(int size){
        data = (Item[]) new Object[size];
    }

    // List是否为空
    public boolean isEmpty(){
        return last==-1;
    }

    // 返回List的大小
    public int size(){
        return last+1;
    }

    // 在第i个位置插入数据(即插入到数组下标为i-1这个位置)
    public void insert(Item item, int i){
        // 如果List满了，不能插入
        if (last==data.length-1){
            System.out.println("数组满，无法插入!");
        }
        // 规定的插入位置在1~n+1之间
        if (i < 1 || i > last+2){
            System.out.println("插入位置非法，无法插入!");
        }
        // 在插入之前需要先将数据往后挪
        for (int j=last; j>=i-1; j--){
            data[j+1] = data[j];
        }
        data[i-1] = item;
        last = last + 1;
    }

    // 在第i个位置删除数据(即删除数组下标为i-1这个位置)
    public void delete(int i){
        // 如果List空，不能删除
        if (isEmpty()){
            System.out.println("List为空，不能删除");
        }
        // 规定的删除位置在1~n+1
        if (i < 1 || i > last+2){
            System.out.println("删除位置非法，无法插入!");
        }
        // 在删除之后需要先将数据往前挪
        for (int j=i-1; j<last; j++){
            data[j] = data[j+1];
        }
        last = last - 1;
    }

    // 查找某个元素，如果查找到，返回下标，否则返回-1
    public int find(Item item){
        for (int i=0; i<last+1; i++){
            if (data[i]==item){
                return i;
            }
        }
        return -1;
    }

    public void printData(){
        for (Item item:data){
            System.out.print(" " + item);
        }
        System.out.println("");
    }

    // 测试
    public static void main(String[] args) {
        List<Integer> testList = new List(5);
        testList.insert(1,1);
        testList.insert(2,2);
        testList.insert(3,3);
        testList.insert(4,4);
        testList.insert(5,5);
        testList.printData();
        testList.delete(1);
        testList.printData();
        System.out.println(testList.find(3));
    }
}
