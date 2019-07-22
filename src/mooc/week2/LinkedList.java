package mooc.week2;

/**
 * Created on 2019/7/22 0022
 * BY Jianlong
 */
public class LinkedList<Item> {
    private Node head;
    private int N; // 结点的数量（线性表中的元素数量）

    // node结点类
    private class Node{
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    // 线性表的长度
    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return head==null;
    }

    // 按序号查找
    public Node findXth(int X){
        Node temp = head;
        int i = 1;
        while (temp != null && i < X){
            temp = temp.next;
            i = i+1;
        }
        if (i == X){
            return temp;
        } else {
            return null;
        }
    }

    // 在第i个位置插入数据
    public void insert(int i, Item item){
        // 因为是链表，所以不需要关心空间的问题
        // 插入情况分为两大类：插入表头，插入其他位置（分为两步：找到插入位置的前一个结点，让插入节点的next指向前一个结点的next结点，前一个结点的next指向插入节点）
        Node temp, p;
        // 插入表头
        if (i == 1){
            temp = new Node(item, head);
            head = temp;
            N = N+1;
            return;
        }
        p = findXth(i-1);
        if (p == null){
            System.out.println("参数i错误!");
            return;
        } else{
            temp = new Node(item, p.next);
            p.next = temp;
            N = N+1;
            return;
        }
    }

    // 在第i个位置删除数据
    public void delete(int i){
        // 删除的情况也分为两类：删除表头，删除其他地方（分为两步：找到被删结点的前一个结点p，让p结点的next指向被删结点的next结点）
        // Java有垃圾回收机制，所以不需要释放
        Node p;
        if (i == 1){
            if (head == null){
                System.out.println("链表为空!");
                return;
            } else{
                head = head.next;
                N = N-1;
                return;
            }
        }
        p = findXth(i-1);
        if (p == null || p.next == null){
            System.out.println("第i个结点不存在!");
        } else {
            p.next = p.next.next;
            N = N-1;
        }
    }

    public void printData(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList();
        testList.insert(1,1);
        testList.insert(2,2);
        testList.insert(3,3);
        testList.insert(4,4);
        testList.insert(5,5);
        testList.printData();
        testList.delete(3);
        testList.printData();
        System.out.println(testList.length());
    }
}
