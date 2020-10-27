### 栈和队列

#### 栈

- 栈也是一种线性结构
- 相比数组，栈对应的操作是数组的子集
- 只能从一端添加元素，也只能从一端取出元素
- 这一端称为**栈顶**
- **LIFO**（后进先出），栈在数据结构里拥有着不可思议的作用

##### 栈的应用

- 无处不在的Undo操作（撤销）
- 程序调用所使用的系统栈

##### 栈的实现

```java
class Stack<E>{
    void push(E e){};
    E pop(){};
    E peek(){}; // 查看栈顶元素
    int getSize(){};
    boolean isEmpty(){};
}
```

从用户的角度看，支持这些操作就好。具体底层实现，用户不关心，实际底层有多种实现方式。设计一个接口，多种方式对接口进行实现。

##### 使用栈解决问题-有效的括号

> 给定一个只包括`'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。
>
> 有效字符串需满足：
>
> 1. 左括号必须用相同类型的右括号闭合。
> 2. 左括号必须以正确的顺序闭合。

#### 队列Queue

队列也是一种数据结构，相比数组来说，队列的操作是数组的子集，只能从一端添加元素（队尾），只能从另外一端（队首）取出元素。

队列是一种**先进先出**的数据结构（先到先得）FIFO。

```java
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
```

##### 数组队列的问题

在进行出队和入队操作时，根据选择的队首的情况的不同，总会有一个操作的时间复杂度变为`O(n)`。

##### 循环队列

分别设立两个指针`front`、`tail`指向队首元素和队尾元素。

当`front == tail`时，队列为空。`(tail + 1)%capacity == front`时，队列满。循环队列循环起来的秘诀就是取余数操作。