package ap.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static int result;

    public static void main(String[] args) {
        Map<String, Integer> excitement = new HashMap<>();
        excitement.put("NY", 10000);
        excitement.put("SF", 1000);
        excitement.put("DAL", 500);
        excitement.put("LA", 20000);
        excitement.put("CHI", 3000);
        excitement.put("SJ", 15000);

        String[][] flights = {{"NY", "SF"}, {"NY", "LA"}, {"CHI", "LA"}, {"SJ", "SF"}};

        System.out.println(maximumExcitement(excitement, flights));
    }

    private static int maximumExcitement(Map<String, Integer> excitement, String[][] flights) {
        result = Integer.MIN_VALUE;
        Map<String, Set<String>> adj = new HashMap<>();

        for (String[] pair : flights) {
            if (!adj.containsKey(pair[0])) {
                Set<String> set = new HashSet<>();
                set.add(pair[1]);
                adj.put(pair[0], set);
            } else {
                adj.get(pair[0]).add(pair[1]);
            }

            if (!adj.containsKey(pair[1])) {
                Set<String> set = new HashSet<>();
                set.add(pair[0]);
                adj.put(pair[1], set);
            } else {
                adj.get(pair[1]).add(pair[0]);
            }
        }

        Map<String, Boolean> visited = new HashMap<>();
        for (String city : excitement.keySet()) {
            visited.put(city, false);
        }

        for (String city : adj.keySet()) {
            dfs(city, visited, adj, excitement, 0, 0);
        }

        return result;
    }

    private static void dfs(String city, Map<String, Boolean> visited, Map<String, Set<String>> adj, Map<String, Integer> excitement, int flightCount, int totalExcitement) {
        if (flightCount == 4) {
            result = Math.max(result, totalExcitement);
            return;
        } else {
            if (visited.get(city))
                return;

            visited.put(city, true);
            totalExcitement += excitement.get(city);
            for (String cty : adj.get(city)) {
                dfs(cty, visited, adj, excitement, flightCount + 1, totalExcitement);
            }
            visited.put(city, false);
        }
    }
}
