package streams;

import java.util.ArrayList;
import java.util.List;

public class KMap {
    static void run() {
        List<String> list = new ArrayList<>();
        list.add("Dove");
        list.add("Daniel");
        list.add("Ryan");

        list.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
    }
}
