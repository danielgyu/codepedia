package com.mayfly.interview.hashes;

import java.util.*;

public class ProgrammersBestAlbum {

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Pair> totalMap= new HashMap<>();
        HashMap<String, List<List<Integer>>> playsMap = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            if (!totalMap.containsKey(genres[i])) {
                totalMap.put(genres[i], new Pair(0, genres[i]));
                playsMap.put(genres[i], new ArrayList<>());
            }
            Pair pair = totalMap.get(genres[i]);
            pair.add(plays[i]);

            List<List<Integer>> playsTotalList = playsMap.get(genres[i]);
            playsTotalList.add(new ArrayList<>(Arrays.asList(plays[i], i)));
        }

        List<Pair> pairList = new ArrayList<>(totalMap.values());
        pairList.sort((p1, p2) -> p2.num.compareTo(p1.num));

        List<Integer> res = new ArrayList<>();
        for (Pair pair : pairList) {
            List<List<Integer>> playList = playsMap.get(pair.name);
            playList.sort((p1, p2) -> {
                if (p1.get(0).compareTo(p2.get(0)) == 0) {
                    return p2.get(1).compareTo(p1.get(1));
                } else {
                    return p1.get(0).compareTo(p2.get(0));
                }
            });

            for (int i = 0; i < 2; i++) {
                if (playList.size() > 0) {
                    List<Integer> popped = playList.remove(playList.size() - 1);
                    res.add(popped.get(1));
                }
            }
        }

        int[] converted = res.stream().mapToInt(i -> i).toArray();
        System.out.println("Arrays.toString(converted) = " + Arrays.toString(converted));
        return converted;
    }

    static class Pair {
        Integer num;
        String name;

        Pair(Integer num, String name) {
            this.num = num;
            this.name = name;
        }

        void add(Integer num) {
            this.num += num;
        }

        public String toString() {
            return "num=" + num + "  " + "name=" + name;
        }
    }

    public static void run() {
        solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        );

        solution(
                new String[]{"classic"},
                new int[]{500}
        );

        solution(
                new String[]{"classic", "classic"},
                new int[]{500, 500}
        );
    }
}
