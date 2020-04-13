## 链表和递归

### LeetCode中和链表相关的问题

#### LeetCode 203问题

删除链表中的结点，使用虚拟头结点可以使问题解决统一，不需要分情况进行解决。

```java
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
}
```

### 递归

本质上，递归就是将原来的问题转换为更小的同一问题。例如，数组求和：

更小的同一问题`Sum(arr[0...n-1]) = arr[0] + Sum(arr[1...n-1])`

更小的同一问题`Sum(arr[1...n-1]) = arr[1] + Sum(arr[2...n-1])`

最基本的问题`Sum(arr[n-1...n-1]) = arr[n-1] + 0`

#### 递归算法的基本求解

- 1、求解最基本问题。（递归的出口，边界）
- 2、把原问题转化为子问题，并由子问题得到原问题的解。（递归函数）
- 注意递归函数的“宏观”语意，递归函数就是一个函数，完成一个功能，不用纠结于递归是怎么调用的。

递归调用是有代价的，主要是两个方面，1、函数调用需要花费时间，2、占用系统栈空间。

调试递归代码：通过输出语句查看运行过程的信息可以帮助我们进行代码的调试。

#### 更多的链表

双向链表、循环链表、双向循环链表、数组链表。

参考资料：LinkedListProblem。