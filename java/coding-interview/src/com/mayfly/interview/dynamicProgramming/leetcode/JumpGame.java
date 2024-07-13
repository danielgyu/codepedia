package com.mayfly.interview.dynamicProgramming.leetcode;

public class JumpGame {
    boolean reachedEnd;
    Boolean[] memo;
    public Boolean jump(int[] nums, int idx) {
        if (idx == nums.length-1) {
            reachedEnd = true;
            return true;
        }
        if (idx > nums.length-1 || (idx <= nums.length-1 && nums[idx] == 0)) {
            return false;
        }

        if (memo[idx] != null && memo[idx]) {
            return true;
        }

        if (memo[idx] != null && !memo[idx]) {
            return false;
        }

        for (int i=nums[idx]; i>=0; i--) {
            memo[idx] = jump(nums, idx+i);
        }

        return memo[idx];
    }

    public boolean canJump(int[] nums) {
        reachedEnd = false;
        memo = new Boolean[nums.length];

        jump(nums, 0);
        System.out.println("reachedEnd = " + reachedEnd);
        return reachedEnd;
    }

    public boolean canJumpLeetcodeOptimal(int[] nums) {
        int reachable = 0;

        for (int i=0; i<nums.length; i++) {
            if (i > reachable) {
                System.out.println("false");
                return false;
            }
            reachable = Math.max(reachable, i+nums[i]);
        }
        System.out.println("true");
        return true;
    }

    public void run() {
        /*
        canJump(new int[]{2, 3, 1, 1, 4});
        canJump(new int[]{3, 2, 1, 0, 4});
        canJump(new int[]{0});
        canJump(new int[]{1, 0});
        canJump(new int[]{2, 0});
         */

        canJumpLeetcodeOptimal(new int[]{2, 3, 1, 1, 4});
        canJumpLeetcodeOptimal(new int[]{3, 2, 1, 0, 4});
        canJumpLeetcodeOptimal(new int[]{0});
        canJumpLeetcodeOptimal(new int[]{1, 0});
        canJumpLeetcodeOptimal(new int[]{2, 0});
    }
}
