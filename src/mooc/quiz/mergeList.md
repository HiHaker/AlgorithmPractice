// 两个有序链表的合并
```c
void Attach(ElementType Data, PtrToNode * node){
    PtrToNode newNode = (PtrToNode)malloc(sizeof(struct Node));
    newNode->Data = Data;
    newNode->Next = NULL;
    (*node)->Next = newNode;
    (*node) = (*node)->Next;
}
List Merge(List L1, List L2){
    // 构造一个带头结点的链表
    List L3 = (PtrToNode)malloc(sizeof(struct Node));
    // 因为带头结点，所以让其指向下一个结点
    List A = L1->Next;
    List B = L2->Next;
    L3->Next = NULL;
    PtrToNode curNode = L3;
    // 当L1 L2不为空时
    while (A && B){
        if (A->Data < B->Data){
            Attach(A->Data,&curNode);
            A = A->Next;
        } else{
            Attach(B->Data,&curNode);
            B = B->Next;
        }
    }
    while(A){
        Attach(A->Data,&curNode);
        A = A->Next;
    }
    while(B){
        Attach(B->Data,&curNode);
        B = B->Next;
    }
    L1->Next = NULL;
    L2->Next = NULL;
    return L3;
}
```