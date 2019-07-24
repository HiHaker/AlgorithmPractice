package mooc.quiz;

import java.util.Scanner;

/**
 * Created on 2019/7/24 0024
 * BY Jianlong
 * 多项式的运算
 */
public class Polynomial {
    private Node first = new Node(0,0,null); // 多项式的入口，链表的头结点
    private class Node{
        int coef; // 系数
        int expon; //指数
        Node next; // 指向下一个结点
        // 构造函数
        public Node(int coef, int expon, Node next) {
            this.coef = coef; // 多项式的系数
            this.expon = expon; // 多项式的指数
            this.next = next;
        }
    }

    public Polynomial(Node first){
        this.first = first;
    }

    // 生成多项式
    public Polynomial(String[] data, int num){
        int count = 1;
        Node temp = first;
        for (int i=0; i<num; i++){
            Node newNode = new Node(Integer.parseInt(data[count]),Integer.parseInt(data[count+1]),null);
            temp.next = newNode;
            temp = temp.next;
            count = count + 2;
        }
    }

    public Node getNode(){
        return first;
    }

    // 多项式的加法(A+B)
    Polynomial polyAdd(Polynomial p){
        Node A = first.next; // A结点用于遍历当前的多项式
        Node B = p.getNode().next; // B结点用于遍历传入的多项式
        Node C = new Node(0,0,null); // C结点用于存储结果多项式
        Node temp = C;

        while (A != null && B != null){
            // 如果A的指数大，将结点接入C
            if (A.expon > B.expon){
                temp.next = new Node(A.coef,A.expon,null);
                temp = temp.next;
                A = A.next;
            } else if(A.expon < B.expon){
                temp.next = new Node(B.coef,B.expon,null);
                temp = temp.next;
                B = B.next;
            } else{
                if (A.coef+B.coef != 0){
                    temp.next = new Node(A.coef+B.coef,A.expon,null);
                    temp = temp.next;
                }
                A = A.next;
                B = B.next;
            }
        }

        for ( ; A != null; A = A.next){
            temp.next = new Node(A.coef,A.expon,null);
            temp = temp.next;
        }
        for ( ; B != null; B = B.next){
            temp.next = new Node(B.coef,B.expon,null);
            temp = temp.next;
        }

        Polynomial result = new Polynomial(C);
        return result;
    }

    // 多项式的乘法
    Polynomial polyMulti(Polynomial p){
        Polynomial result = new Polynomial(new Node(0,0,null));
        Node A = first.next;
        Node B;
        Node C;
        // 多项式A的每一项乘以多项式B，这些相乘的结果累加
        for ( ; A != null; A = A.next){
            B = p.getNode().next;
            Polynomial current = new Polynomial(new Node(0,0,null));
            C = current.getNode();
            for ( ; B != null; B = B.next){
                C.next = new Node(A.coef * B.coef, A.expon + B.expon,null);
                C = C.next;
            }
            result = result.polyAdd(current);
        }
        return result;
    }

    // 输出多项式
    public void printData(){
        boolean flag = true;
        Node temp = first.next;
        // 如果多项式为0，输出0 0
        if (temp == null){
            System.out.print("0 0");
            return;
        }
        while (temp != null){
            if (flag){
                System.out.print(temp.coef + " " + temp.expon);
                flag = false;
            } else {
                System.out.print(" " + temp.coef + " " + temp.expon);
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] dataA = in.nextLine().split(" ");
        String[] dataB = in.nextLine().split(" ");
        Polynomial testA = new Polynomial(dataA,Integer.parseInt(dataA[0]));
        Polynomial testB = new Polynomial(dataB,Integer.parseInt(dataB[0]));
        Polynomial result1 = testA.polyAdd(testB);
        Polynomial result2 = testA.polyMulti(testB);
        result2.printData();
        System.out.println();
        result1.printData();

//        Scanner in = new Scanner(System.in);
//        String[] test = in.nextLine().split(" ");
//        Polynomial testP = new Polynomial(test,Integer.parseInt(test[0]));
//        testP.printData();
    }
}