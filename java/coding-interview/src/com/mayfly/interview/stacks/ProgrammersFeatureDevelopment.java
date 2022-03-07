package com.mayfly.interview.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammersFeatureDevelopment {
    static int full = 100;

    public static int[] solution(int[] progresses, int[] speeds) {
        int days = 0, done = 0;
        List<Integer> res = new ArrayList<>();
        
        for (int i=0; i < progresses.length; i++) {
            progresses[i] += (days * speeds[i]);
            if (progresses[i] >= 100) {
                done++;
                continue;
            } else if (progresses[i] < 100 && i > 0) {
                res.add(done);
                done = 0;
            }

            while (progresses[i] < full) {
                days++;
                progresses[i] += speeds[i];
            }
            done++;
        }
        res.add(done);

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void run() {
        int[] res1 = solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
        );
        System.out.println("Arrays.toString(res1) = " + Arrays.toString(res1));

        int[] res2 = solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        );
        System.out.println("Arrays.toString(res1) = " + Arrays.toString(res2));
    }
}
