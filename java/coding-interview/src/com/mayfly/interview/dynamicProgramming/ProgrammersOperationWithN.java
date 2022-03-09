package com.mayfly.interview.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgrammersOperationWithN {
    static int n;
    static int target;
    static int answer = -1;
    static int answer2 = -1;

    public static int bfsSolution(int N, int number) {
        dfs2(N, number, 0, 0);
        return answer2;
    }

    public static void dfs2(int N, int number, int count, int sum) {
        if(count>8) return;
        if(number==sum)	{
            if(answer2==-1)	answer2=count;
            else answer2=Math.min(answer2, count);
        }
        int X=N;
        for(int i=1;i<=8-count;i++) {
            dfs2(N,number,i+count,sum+X);
            dfs2(N,number,i+count,sum-X);
            dfs2(N,number,i+count,sum*X);
            dfs2(N,number,i+count,sum/X);
            X=(10*X)+N;
        }
    }

    public static int solutionUsingBFS(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer;
    }

    public static void dfs(int depth, int prev) {
        if (depth> 8) return;

        if (prev == target) {
            if (answer == -1) answer = prev;
            else answer = Math.min(answer, prev);
        }

        int temp = n;
        for (int i = 1; i < 8 - depth; i++) {
            dfs(depth + i, prev + temp);
            dfs(depth + i, prev - temp);
            dfs(depth + i, prev *  temp);
            dfs(depth + i, prev / temp);
            temp = temp * 10 + n;
        }
    }

    public static void run() {
        //System.out.println("solution(5, 12) = " + solution(5, 12));
        //System.out.println("solution(3, 9) = " + solution(3, 9));

        System.out.println("solutionUsingBFS(5, 12) = " + solutionUsingBFS(5, 12));

        System.out.println("bfsSolution(5, 12) = " + bfsSolution(5, 12));
    }

    public static int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();

        for (int i=0; i<9; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);

        for (int i = 2; i < 9; i++) {
            Set<Integer> currentSet = list.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> left = list.get(j);
                Set<Integer> right = list.get(i-j);

                for (Integer l : left) {
                    for (Integer r : right) {
                        currentSet.add(l + r);
                        currentSet.add(l - r);
                        currentSet.add(l * r);
                        if (l != 0 && r != 0) currentSet.add(l / r);
                    }
                }
            }
            currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> set : list) {
            if (set.contains(number)) return list.indexOf(set);
        }

        return -1;
    }
}
