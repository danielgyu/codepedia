package com.mayfly.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    public void testTournamentWinner() {
        ArrayList<String> group1 = new ArrayList<>(Arrays.asList("Python", "C#"));
        ArrayList<String> group2 = new ArrayList<>(Arrays.asList("Javascript", "Python"));
        ArrayList<String> group3 = new ArrayList<>(Arrays.asList("Python", "C#"));
        ArrayList<ArrayList<String>> competition = new ArrayList<>(Arrays.asList(group1, group2, group3));

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0));

        String winner = tournamentWinner(competition, results);

        System.out.println(winner);
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int count = 0;
        Map<String, Integer> winnerMap = new HashMap<>();

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i) == 0) {
                winnerMap = incrementMap(winnerMap, competitions.get(i).get(1));
            } else {
                winnerMap = incrementMap(winnerMap, competitions.get(i).get(0));
            }
        }

        return highestScorer(winnerMap);
    }

    public Map<String,Integer> incrementMap(Map<String, Integer> map, String winner) {
        if (map.containsKey(winner)) {
            map.put(winner, map.get(winner) + 1);
        } else {
            map.put(winner, 1);
        }
        return map;
    }

    public String highestScorer(Map<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }
}
