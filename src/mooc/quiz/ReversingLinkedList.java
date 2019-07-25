package mooc.quiz;

import java.util.Scanner;

/**
 * Created on 2019/7/25 0025
 * BY Jianlong
 */
public class ReversingLinkedList {

    private int first; // 起始指针
    private Node[] nodes = new Node[100001]; // 结点群

    private class Node{
        int data; // 数据
        int next; //指向下一个数的指针

        public Node(int data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    public ReversingLinkedList(int first) {
        this.first = first;
    }

    // 加入结点
    public void addNode(int index, int data, int nextIndex){
        nodes[index] = new Node(data,nextIndex);
    }

    public int size(){
        int size = 1;
        Node temp = nodes[first];
        while(temp.next != -1){
            temp = nodes[temp.next];
            size = size + 1;
        }
        return size;
    }

    // 删除第n个结点，注意：这里是返回特殊结点，结点数据和索引，虽然和Node形式相同
    public Node deleteN(int n){
        int index;
        Node deleted;
        Node temp = nodes[first];
        // 如果删除的是第一个结点
        if (n == 1){
            index = first;
            deleted = nodes[first];
            first = deleted.next;
            deleted.next = index;
            return deleted;
        }
        // 先找到第n-1个结点
        for (int i=1; i<n-1; i++){
            temp = nodes[temp.next];
        }
        index = temp.next;
        deleted = nodes[temp.next];
        temp.next = deleted.next;
        deleted.next = index;
        return deleted;
    }

    // 在第N个结点后面插入结点
    public void insertAfterN(Node inserted, int n){
        int index;
        Node temp = nodes[first];
        // 先找到第n个结点
        for (int i=1; i<n; i++){
            temp = nodes[temp.next];
        }
        index = inserted.next;
        inserted.next = temp.next;
        temp.next = index;
    }

    public void reverseList(int sum, int parameters){
        Node mid;
        int start = 1;
        int end = parameters - 1;
        // 当剩余的结点数大于等于参数时，就继续操作
        while (sum >= parameters){
            // 不断地删除结点，插入结点
            for (int i=end; i>=start; i--){
                mid = deleteN(i);
                insertAfterN(mid,end);
            }
            end = end + parameters;
            sum = sum - parameters;
            start = start + parameters;
        }
    }

    // 输出链表结点信息
    public void printNode(){
        Node temp = nodes[first];
        while(temp.next != -1){
            System.out.print(temp.data + " ");
            temp = nodes[temp.next];
        }
        System.out.print(temp.data);
    }

    public void printData(){
        int index = first;
        Node temp = nodes[first];
        while(temp.next != -1){
            System.out.printf("%05d %d %05d\n",index,temp.data,temp.next);
            index = temp.next;
            temp = nodes[temp.next];
        }
        System.out.printf("%05d %d %d",index,temp.data,temp.next);
    }

    public static void main(String[] args) {
        int sum; // 结点总数
        int parameter; // 参数
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        ReversingLinkedList list = new ReversingLinkedList(Integer.parseInt(line[0]));
        sum = Integer.parseInt(line[1]);
        parameter = Integer.parseInt(line[2]);

        // 填充结点数据
        for (int i=0; i<sum; i++){
            line = in.nextLine().split(" ");
            list.addNode(Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2]));
        }
        list.reverseList(list.size(),parameter);
        list.printData();
        System.out.println();
    }
}
