package streams;

import java.util.ArrayList;
import java.util.List;

public class KFlatMap {

    static void run() {
        List<List<List<String>>> list = makeLists();

        list.stream()
                .flatMap(s -> s.stream())
                .flatMap(s -> s.stream())
                .filter(s -> "A".equals(s.toString()))
                .forEach(System.out::println);
    }

    static List<List<List<String>>> makeLists() {
        List<String> firstList = new ArrayList<>();
        firstList.add("A");
        firstList.add("B");
        firstList.add("C");

        List<List<String>> secondList = new ArrayList<>();
        secondList.add(firstList);

        List<List<List<String>>> thirdList = new ArrayList<>();
        thirdList.add(secondList);

        return thirdList;
    }
}
