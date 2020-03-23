package imooc.chapter5;

/**
 * Created on 2020/3/3 0003
 * BY Jianlong
 * LeetCode 203 移除链表中的元素
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    // 解法1 不使用虚拟头结点
    public ListNode removeElements1(ListNode head, int val) {
        // 因为删除节点要找到其前一个结点，删除头结点和删除其他节点不一样，所以要分开处理
        while (head != null && head.val==val){
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }

        if (head == null){
            return null;
        }

        // 进行到此步时，头结点不是val值了
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    // 解法2 使用虚拟头结点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 进行到此步时，头结点不是val值了
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        // 注意这里不能返回head，要返回dummyHead.next才对
        return head;
    }

    // 解法3 使用递归算法进行求解
    public ListNode removeElements3(ListNode head, int val){
        // 最基本的情况
        if (head == null){
            return null;
        }
        // 删除头结点后的链表里的元素
        ListNode childList = removeElements3(head.next, val);
        // 还要考虑头结点的情况
        if (head.val == val){
            return childList;
        } else{
            head.next = childList;
            return head;
        }
    }
}
