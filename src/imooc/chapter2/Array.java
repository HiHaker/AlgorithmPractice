package imooc.chapter2;

/**
 * Created on 2020/1/8 0008
 * BY Jianlong
 */
public class Array<E> {
    private E[] data;
    // ��ЧԪ��
    private int size;

    // �޲����Ĺ��캯��
    public Array(){
        this(10);
    }

    // ���캯��
    public Array(int capacity){
        // Java��֧��newһ����������
        data = (E[])new Object[capacity];
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public E get(int index){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index, E e){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    // �Ƿ����ĳ��Ԫ��
    public boolean contains(E e){
        for (int i=0; i<size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // �ҵ�Ԫ��e��Ӧ������
    public int find(E e){
        for (int i=0; i<size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // ���븴��
    // ͷ���Ԫ��
    public void addFirst(E e){
        add(0,e);
    }

    // ĩβ����Ԫ��
    public void addLast(E e){
        add(size,e);
    }

    private void resize(int newcapacity){
        E[] newData = (E[]) new Object[newcapacity];
        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    // λ�ò���Ԫ��
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and <= size");
        }

        if (size == data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full!");
            resize(2 * data.length);
        }

        for (int i=size-1; i>=index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    // ��������ɾ��indexλ�õ�Ԫ�أ�����ɾ����Ԫ��
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and <= size");
        }

        E ret = data[index];
        for (int i= index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }

        return ret;
    }

    // ��������ɾ��Ԫ��e����һ��Ԫ�أ�
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i=0; i<size; i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}