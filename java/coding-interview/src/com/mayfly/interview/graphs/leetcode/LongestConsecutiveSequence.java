package com.mayfly.interview.graphs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int solution(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        Set<Integer> seen = new HashSet<>();
        int longest = 1;
        for (int n : nums) {
            if (seen.contains(n)) continue;
            int current = 1;

            int left = n-1;
            while (set.contains(left)) {
                seen.add(left--);
                current++;
            }

            int right = n+1;
            if (set.contains(right)) {
                seen.add(right++);
                current++;
            }

            longest = Math.max(longest, current);
            seen.add(n);
        }
        return longest;
    }

    public static void run() {
        System.out.println(solution(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
