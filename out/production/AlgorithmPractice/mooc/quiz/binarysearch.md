二分查找
```c
// 注意，题目说明L数组的元素是从下标1开始存储的
Position BinarySearch(List L, ElementType X){
    int left = 1;
    int right = L->Last;
    int mid = (left + right)/2;
    
    while(left <= right){
        if (L->Data[mid] == X){
            return mid;
        } else if (L->Data[mid] < X) {
            left = mid + 1;
        } else if (L->Data[mid] > X) {
            right = mid - 1;
        }
        mid = (left + right)/2;
    }
    
    return NotFound;
}
```