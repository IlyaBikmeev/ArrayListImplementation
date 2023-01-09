package MyList;

import java.util.Comparator;

//add get remove addAll sort
public interface List<T> {
    void add(T element);
    T get(int index);
    void remove(int index);
    void remove(T element);
    void sort(Comparator<? super T> comparator);
    int size();
    int indexOf(T element);
}
