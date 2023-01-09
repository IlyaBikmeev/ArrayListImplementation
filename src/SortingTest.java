import MyList.List;
import MyList.MyArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortingTest {
    public static void main(String[] args) {
        List<Integer> list = new MyArrayList<>();
        Random random = new Random(18121998);
        for(int i = 0; i < 50; ++i) {
            list.add(random.nextInt(50));
        }
        System.out.println("До сортировки: " + list);
        list.sort(Comparator.naturalOrder());
        System.out.println("После сортировки: " + list);
    }
}
