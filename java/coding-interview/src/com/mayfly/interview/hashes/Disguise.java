package com.mayfly.interview.hashes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Disguise {

    public static int disguise(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];

            if (!map.containsKey(type)) {
                map.put(type, 1);
            } else {
                map.put(type, map.get(type) + 1);
            }
        }

        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }

    public static void run() {
        int ans1 = disguise(new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"greenturban", "headgear"},
        });
        System.out.println("ans1 = " + ans1);

        int ans2 = disguise(new String[][]{
                {"crowmask", "face"},
                {"blue", "face"},
                {"smoky", "face"},
        });
        System.out.println("ans = " + ans2);
    }
}
