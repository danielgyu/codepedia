package com.mayfly.interview.searching;

public class FaultyUsers {
    private String[] bannedId;
    private String[] userId;
    private int count = 0;

    public boolean isMatch(String x, String y) {
        if (x.length() != y.length()) {
            return false;
        }

        for (int i = 0; i < x.length(); i++) {
            char xChar = x.charAt(i);
            char yChar = y.charAt(i);
            if (xChar == '*' || yChar == '*') continue;
            if (xChar != yChar) return false;
        }

        return true;
    }

    public void recurse(int userIdx, int bannedIdx, int match) {
    }


    public int solution(String[] user_id, String[] banned_id) {
        /*
         * 0, 0이 같다면 1, 1로 넘어가고,
         * 1, 1이 안 같으니 2, 1로 넝머가고
         * 3, 2가 같다면 count를 올리고
         * 4, 2까지도 확인을 한다
         */

        return this.count;
    }

    public void run() {
        solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "abc1**"}
        );

        /*
        solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"*rodo", "*rodo", "******"}
        );

        solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "*rodo", "******", "******"}
        );
         */
    }
}
