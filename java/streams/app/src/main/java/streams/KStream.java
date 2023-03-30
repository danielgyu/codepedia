package streams;

import java.util.ArrayList;
import java.util.List;

public class KStream {
    static void run() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        long count = list.stream()
                .filter(num -> num < 5)
                .count();
        System.out.println(count);
    }
}
