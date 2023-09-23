import java.util.*;

/*
    https://leetcode.com/problems/reconstruct-itinerary/description/
*/
class ReconstructItinerary {
    public static void main(String... args) {
        List<List<String>> tickets1 = List.of(List.of("MUC","LHR"), List.of("JFK","MUC"), List.of("SFO","SJC"), List.of("LHR","SFO"));
        System.out.println(new Solution().findItinerary(tickets1)); // ["JFK","MUC","LHR","SFO","SJC"]

        List<List<String>> tickets2 = List.of(List.of("JFK","KUL"), List.of("JFK","NRT"), List.of("NRT","JFK"));
        System.out.println(new Solution().findItinerary(tickets2)); // ["JFK","NRT","JFK","KUL"]
    }
}

class Solution {
    private Stack<String> result = new Stack<>();
    private Map<String, List<City>> adj;
    private int itinerarySize;

    public List<String> findItinerary(List<List<String>> tickets) {
        itinerarySize = tickets.size() + 1;
        intiAdj(tickets);
        // System.out.println(adj);

        result.push("JFK");
        visit("JFK");
        return result.stream().toList();
    }

    private boolean visit(String city) {
        if (result.size() == itinerarySize) {
            return true;
        }

        var nextCities = adj.getOrDefault(city, List.of());
        for(int i = 0; i < nextCities.size(); i++) {
            City nextCity = nextCities.get(i);
            if (nextCity.visited == false) {
                result.push(nextCity.name);
                nextCity.visited = true;
                if (visit(nextCity.name)) {
                    return true;
                }
                nextCity.visited = false;
                result.pop();
            }
        }

        return false;
    }

    private void intiAdj(List<List<String>> tickets) {
        this.adj = new HashMap<>();

        for(List<String> iti : tickets) {
            if (!adj.containsKey(iti.get(0))) {
                adj.put(iti.get(0), new ArrayList<>());
            }
            adj.get(iti.get(0)).add(new City(iti.get(1)));
        }

        for(String key : adj.keySet()) {
            Collections.sort(adj.get(key), (a, b) -> a.name.compareTo(b.name));
        }
    }

    class City {
        String name;
        boolean visited;
        City(String n) {
            name = n;
            visited = false;
        }
        public String toString() {
            return "City("+name+", "+visited+")";
        }
    }
}
