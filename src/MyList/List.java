package MyList;

import java.util.Comparator;

public interface List<T> {
    void add(T element);
    void addAll(List<? extends T> other);
    T get(int index);
    void remove(int index);
    void remove(T element);
    void sort(Comparator<? super T> comparator);
    int size();
    int indexOf(T element);
}
