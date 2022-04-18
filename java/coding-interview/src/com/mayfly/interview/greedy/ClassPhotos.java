package com.mayfly.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {
    public static boolean solution(List<Integer> red, List<Integer> blue) {
        Collections.sort(red);
        Collections.sort(blue);

        int mono = 0;
        for (int i = 0; i < red.size(); i++) {
            if (red.get(i) > blue.get(i)) {
                mono += 1;
            } else {
                mono -= 1;
            }
        }

        return Math.abs(mono) == red.size();
    }

    public static void run() {
        System.out.println(solution(
                new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4)),
                new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5))
        ));
        System.out.println(solution(
                new ArrayList<>(Arrays.asList(1, 3, 라6)),
                new ArrayList<>(Arrays.asList(2, 4, 5))
        ));
    }
}
