### 什么是线性表？

​	线性表（Linear List），是由同类型数据元素构成有序序列的线性结构，表中元素个数称为线性表的<u>长度</u>；线性表没有元素时，称为<u>空表</u>；表的起始位置称为<u>表头</u>，表的结束位置称为<u>表尾</u>。

### 抽象数据类型描述

​	类型名称：线性表（List）

​	数据对象集：线性表是n（n>=0）个元素构成的有序序列（a,a2,...,an）

​	操作集：Item 表示元素类型，整数 i 表示位置

- `boolean isEmpty()` 线性表是否为空
- `int size()` 线性表中的元素个数
- `void insert(Item item, int i)` 在 i 位置插入元素
- `void delete(int i)` 在第i个位置删除数据(即删除数组下标为i-1这个位置)
- `int find(Item item)` 查找某个元素，如果找到，返回下标；否则返回-1

### 顺序存储实现（固定大小）

​	创建一个泛型类List：

```java
public class List<Item>{
    private Item[] data; // 泛型数组存储数据
    private int last = -1; // last表示最后一个元素的下标
}
```

​	构造函数：

```java
public List(int size){
        data = (Item[]) new Object[size]; // java不允许创建泛型数组，所以需要用到类型转换
}
```

#### 插入数据

​	在这里，我们插入数据的位置范围是1~n+1，即第一个位置到最后一个位置+1（这里的n就表示当前List中的元素个数）。所以我们就会发现我们在插入数据后，这些数据都是连续的。比如：在创建了List之后，数组中没有元素，元素个数为0，那么此时插入的范围就是1~0+1，只有1这个位置可以插入，之后再插入第二个元素，这时元素的个数已经变成了1，此时的范围是1~1+1，以此类推，存储在这个线性表中的数据总会是连续的。

![](https://img3.doubanio.com/view/photo/m/Bg1NRkLq_1i9aygKZexy2w/178857354/x2563484351.jpg)

​	当我们向线性表中插入数据时，首先要看看这个线性表满了没有，如果满了不能插入，判断满的条件就是：`last==data.length-1`如果最后一个元素的下标等于数组的最后一个下标，说明满了。

​	然后，要判断插入的位置是否合法：`i < 1 || i > last+2`(n+1 >= i >= 1)。

​	之前说过，List中存储的数据是连续的，所以我们插入时不能直接插入，需要将元素往后挪出一个空位才能够在特定的位置进行插入：

```java
// 挪动的顺序毫无疑问是从最后一个元素挪，否则你从第i个元素挪的话就会覆盖掉后面的元素
for (int j=last; j>=i-1; j--){
	data[j+1] = data[j];
}
// 插入数据
data[i-1] = item;
// last加1
last = last + 1;
```

#### 删除元素

​	和插入元素类似，只是挪动元素是往前挪动元素，填补删除后留下的空位。直接上代码：

```java
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
```

完整代码：

```java
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
```

### 链式存储实现

​	创建一个泛型类 LinkedList：

```java
public class LinkedList<Item> {
    private Node head; // 线性表的表头（链表的入口）
    private int N; // 结点的数量（线性表中的元素数量）

    // node结点类
    private class Node{
        Item item;
        Node next;
		// 构造器
        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
```

​	求线性表的长度和是否为空：

```java
public int length(){
	return N;
}

public boolean isEmpty(){
	return head==null; // 当head为null或N为0
}
```

​	查找相应的位置的结点：

```java
public Node findXth(int X){
	Node temp = head;
	int i = 1;
    // 当当前结点不为空且位置小于X时
	while (temp != null && i < X){
		temp = temp.next;
		i = i+1;
	}
    // 跳出循环有两种可能，当前结点为空或i==X
	if (i == X){
		return temp;
	} else{
		return null;
	}
}
```

#### 插入数据

​	因为是链式存储，所以不必关心空间的问题，只需care插入问题。

​	要向链表中插入结点，首先要分插入的位置。如果是插到链表的头，需要做特殊处理：让插入结点的next的值变为head，head的值置为新插入的结点；如果插入到其他位置，只需要先找到插入位置的前一个结点p，然后是两步（顺序不能更改）：1、设置插入的结点的next的值为p的next。2、改变p的next的值为插入的结点。

```java
public void insert(int i, Item item){
	Node temp, p;
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
```

#### 删除数据

​	和插入类似，区分删除的是头结点还是其他位置，删除头结点：只需head置为head的next；删除其他结点：找到前一个结点p，使其next置为p.next.next即可，java会自动进行垃圾回收。

```java
public void delete(int i){
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
```

#### 完整代码

```java
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

```

