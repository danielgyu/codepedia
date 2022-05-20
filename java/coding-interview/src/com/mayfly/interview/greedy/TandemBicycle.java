package com.mayfly.interview.greedy;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {
    public static int solution(int[] red, int[] blue, boolean fastest) {
        Arrays.sort(red);
        Arrays.sort(blue);
        int ans = 0;
        if (fastest) {
            for (int left=0, right=red.length-1; left<red.length; left++, right--) {
                ans += Math.max(red[left], blue[right]);
            }
            return ans;
        } else {
            for (int i = 0; i < blue.length; i++) {
                ans += Math.max(red[i], blue[i]);
            }
            return ans;
        }
    }
    public static void run() {
        System.out.println(solution(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, true));
        System.out.println(solution(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, false));
    }
}
