import java.util.*;

/*
    https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
*/
class CountUnreachablePairsOfNodesInUndirectedGraph {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,2}, {0,5}, {2,4}, {1,6}, {5,4}};
        System.out.println(new Solution().countPairs(n, edges)); // 14
    }
}

class Solution {

    List<List<Integer>> adj;
    boolean[] visited;
    // Map<Integer, Integer> groupCount;

    public long countPairs(int n, int[][] edges) {
        this.adj = createAdjacencyList(n, edges);
        this.visited = new boolean[n];
        // this.groupCount = new HashMap<>();


        long result = 0;
        int visitedNodes = 0;

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                int groupCount = dfs(i);
                result += (long)groupCount * visitedNodes;
                visitedNodes += groupCount;
            }
        }

        return result;
    }

    private int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for(int n : adj.get(node)) {
            if (!visited[n]) {
                count += dfs(n);
            }
        }
        return count;
    }

    private List<List<Integer>> createAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }
}
