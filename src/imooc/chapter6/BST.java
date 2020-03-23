package imooc.chapter6;

import java.util.Stack;

/**
 * Created on 2020/3/10 0010
 * BY Jianlong
 * 二分搜索树
 * 类型必须是可以比较的数据类型，所以需要 extends Comparable接口
 */
public class BST<E extends Comparable<E>> {
    // 创建一个私有的内部类
    private class Node{
        public E e;
        public Node left;
        public Node right;

        // 构造函数
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    // 根节点
    private Node root;
    private int size;

    public BST(){
        this.root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    // 向二分搜索树中添加一个元素
    // 分情况：
    //      1、根节点为空
    //      2、根节点不为空
    /*
    public void add(E e){
        if (this.root == null){
            root = new Node(e);
            size++;
        }
        else{
            add(this.root, e);
        }
    }
    */

    // 递归地向以node为根节点的二分搜索树中插入元素
    /*
    private void add(Node node, E e){
        if (e.equals(node.e)){
            return;
        }
        // 当元素小于根节点且左子树为空
        else if (e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }
        // 当元素大于根节点且右子树为空
        else if (e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }

        // 如果不为空，递归地插入到左右子树上
        if (e.compareTo(node.e) < 0){
            add(node.left, e);
        }
        else {
            add(node.right, e);
        }
    }
    */
    // 添加元素（面向用户的接口）
    public void add(E e){
        root = add(root, e);
    }

    // 递归地向以node为根节点的BST中插入元素e
    // 该函数返回的是插入元素e后的二分搜索树的根节点
    private Node add(Node node, E e){
        // 如果node为空
        if (node == null){
            size++;
            // 返回这个节点，才可以连接到原来的BST上
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }
        else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        // 如果相等，就返回原来的根节点
        return node;
    }

    // 在二分搜索树中查找元素
    public boolean isContains(E e){
        return isContains(root, e);
    }

    // 在以node为根节点的BST中查找元素e
    private boolean isContains(Node node, E e){
        if (node == null){
            return false;
        }

        if (e.compareTo(node.e) < 0){
            return isContains(node.left, e);
        }
        else if (e.compareTo(node.e) > 0){
            return isContains(node.right, e);
        }
        // e.compareTo(node.e) == 0
        else {
            return true;
        }
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根节点的BST
    private void preOrder(Node node){
        // 判断当前的根节点是否为空
        if (node == null){
            return;
        }

        // 打印输出当前元素
        System.out.println(node.e);

        // 递归地遍历左子树
        preOrder(node.left);
        // 递归地遍历右子树
        preOrder(node.right);
    }

    // 二分搜索树的前序遍历的非递归写法
    public void preOrderNR(){
        // 创建一个栈用于存储接下来要访问的节点，类似于系统栈的调用过程
        Stack<Node> stack = new Stack<>();
        // 将根节点压入栈
        stack.push(root);

        while(!stack.isEmpty()){
            // 取出栈顶元素
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (!(cur.right == null)){
                stack.push(cur.right);
            }

            if (!(cur.left == null)){
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的中序遍历
    // 二分搜索树的排序后的结果
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根节点的二分搜索树
    private void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的中序非递归写法
    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (!(stack.isEmpty()) || node!= null){
            // 如果当前节点不为空，就把它入栈
            while (node != null){
                stack.push(node);
                // 指向其左子树
                node = node.left;
            }
            // 如果当前节点为空，就从栈顶出栈一个元素
            node = stack.pop();
            System.out.println(node.e);
            // 指向其右子树
            node = node.right;
        }
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 后序遍历以node为根节点的二分搜索树
    private void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 重写此二分搜索树的toString方法
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i=depth; i>=1; i--){
            res.append("--");
        }
        return res.toString();
    }

}
