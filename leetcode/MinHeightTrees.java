import java.util.*;

/*
        https://leetcode.com/problems/minimum-height-trees/
*/

class MinHeightTrees {
    public static void main(String[] args) {
        Solution sol = new Solution();
        /*
            Input: n = 4, edges = [[1,0],[1,2],[1,3]]
            Output: [1]
        */
        int[][] edges1 = {{1,0},{1,2},{1,3}};
        System.out.println(sol.findMinHeightTrees(4, edges1));

        /*
            Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
            Output: [3,4]
        */
        int[][] edges2 = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(sol.findMinHeightTrees(6, edges2));

    }
}

class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2) { // base case
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < n; i++)
                result.add(i);
            return result;
        }

        List<List<Integer>> adj = buildAdj(n, edges);

        int centroids = n;
        List<Integer> leafs = getLeafs(adj);
        // System.out.println("leafs: " + leafs);
        while(centroids > 2)  {
            centroids -= leafs.size();
            leafs = removeAndFindNextLeafs(adj, leafs);
            // System.out.println("new leafs: " + leafs);
        }

        return leafs;
    }

    private List<Integer> removeAndFindNextLeafs(List<List<Integer>> adj, List<Integer> leafs) {
        List<Integer> newLeafs = new LinkedList<>();

        for(int leaf : leafs) {
            int v2 = adj.get(leaf).get(0);
            adj.get(v2).remove(new Integer(leaf));
            if(adj.get(v2).size() == 1) {
                newLeafs.add(v2);
            }
        }
        return newLeafs;
    }

    private List<Integer> getLeafs(List<List<Integer>> adj) {
        List<Integer> leafs = new LinkedList<>();

        for(int v = 0; v < adj.size(); v++) {
            if(adj.get(v).size() == 1) {
                leafs.add(v);
            }
        }
        return leafs;
    }

    private List<List<Integer>> buildAdj(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        // System.out.println(adj);
        return adj;
    }
}
