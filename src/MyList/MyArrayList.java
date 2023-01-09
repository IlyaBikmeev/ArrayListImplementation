package MyList;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> implements List<T>{
    private Object[] data;
    private int size;

    private final static int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void reallocate() {
        int oldCapacity = data.length;
        this.data = Arrays.copyOf(data, oldCapacity * 2);
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < this.size;
    }

    @SuppressWarnings("unchecked")
    private boolean isSorted(Comparator<? super T> comparator) {
        for(int i = 1; i < this.size; ++i) {
            if(comparator.compare((T) data[i - 1], (T) data[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(T element) {
        if(size >= data.length) {
            reallocate();
        }
        data[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(!checkIndex(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    @Override
    public void remove(int index) {
        if(checkIndex(index)) {
            for(int i = index; i < size - 1; ++i) {
                data[i] = data[i + 1];
            }
            --size;
        }
    }

    @Override
    public void remove(T element) {
        int index = indexOf(element);
        if(index != -1) {
            remove(index);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> comparator) {
        if(isSorted(comparator)) {
            return;
        }
        for(int i = 0; i < this.size - 1; ++i) {
            for(int j = i + 1; j < this.size; ++j) {
                if(comparator.compare((T) data[i], (T) data[j]) > 0) {
                    Object buf = data[i];
                    data[i] = data[j];
                    data[j] = buf;
                }
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(T element) {
        for(int i = 0; i < size; ++i) {
            if(element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for(int i = 0; i < size; ++i) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
}
