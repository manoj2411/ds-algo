import java.util.*;

/*
	https://leetcode.com/problems/critical-connections-in-a-network/
*/

class CriticalConnectionsInNetwork {
	public static void main(String[] args) {

		int n = 5;
		List<List<Integer>> connections = new LinkedList<>();
		connections.add(List.of(0,2));
		connections.add(List.of(1,2));
		connections.add(List.of(1,4));
		connections.add(List.of(1,3));
		connections.add(List.of(4,3));
		System.out.println(new Solution().criticalConnections(n, connections));
		// res : [[1,2],[0,2]]

		n = 4;
		connections = new LinkedList<>();
		connections.add(List.of(0,1));
		connections.add(List.of(1,2));
		connections.add(List.of(2,0));
		connections.add(List.of(1,3));
		System.out.println(new Solution().criticalConnections(n, connections));
		// res : [[1,3]]

	}
}


class Solution {

    List<List<Integer>> adj = new ArrayList<>();

    int[] ranks;

    Set<List<Integer>> criticalCons;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(int i = 0; i < n; i++)
            adj.add(new LinkedList<>());

        criticalCons = new HashSet<>();

        for(List<Integer> c : connections) {
            int u = Math.min(c.get(0), c.get(1));
            int v = Math.max(c.get(0), c.get(1));

            adj.get(u).add(v);
            adj.get(v).add(u);

            criticalCons.add(List.of(u, v));
        }

        ranks = new int[n];

        dfs(0, 1, -1);


        List<List<Integer>> result = new LinkedList<>(criticalCons);

        return result;
    }

    private int dfs(int u, int rankFormRoot, int parent) {
        if (ranks[u] > 0) return ranks[u];

        ranks[u] = rankFormRoot;

        int min = rankFormRoot;
        for(int v : adj.get(u)) {

            if(v == parent) continue;

            int rank = dfs(v, rankFormRoot + 1, u);

            // if dfs return rank <= rankFormRoot from root for this connection means the
            //	vertex/connection is part of cycle, means shouldn't be part of the solution.
            if (rank <= rankFormRoot) {
                // System.out.println(" adding " + u + ", " + v + " ")

                var conn = List.of(Math.min(u, v), Math.max(u,v));

                criticalCons.remove(conn);

                min = Math.min(min, rank);
            }

        }

        return min;
    }

}
